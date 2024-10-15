package resource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import dto.Collage;
import dto.User;


@WebServlet("/clg")
public class Collagedao extends HttpServlet{
	
	
	
	public static void addclg(User u, String course, String spl, String clg, Double cgpa, String yop, String ctype) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql:///jobportal","root","tiger");	
			PreparedStatement pstm=connection.prepareStatement("insert into collage values(?,?,?,?,?,?,?)");
			pstm.setInt(1, u.getId());
			pstm.setString(2, course);
			pstm.setString(3, spl);
			pstm.setString(4, clg);
			pstm.setDouble(5, cgpa);
			pstm.setString(6, yop);
			pstm.setString(7, ctype);
			
			
			pstm.executeUpdate();
			
			connection.close();
			pstm.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void addcourse(int id,String crs) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("update collage set degree=? where id=?");
			pstm.setString(1, crs);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			connection.close();
			pstm.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void addspl(int id,String spl) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("update collage set specialization=? where id=?");
			pstm.setString(1, spl);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			connection.close();
			pstm.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void addclgname(int id,String cname) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("update collage set cname=? where id=?");
			pstm.setString(1, cname);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			
			connection.close();
			pstm.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void addcgpa(int id,double cgpa) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("update collage set cgpa=? where id=?");
			pstm.setDouble(1, cgpa);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void addyop(int id,String yop) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("update collage set yop=? where id=?");
			pstm.setString(1, yop);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void addtype(int id,String type) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("update collage set type=? where id=?");
			pstm.setString(1, type);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static Collage getclg(int id) {
		Collage clg=null;
		try {
			
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("select * from collage where id=?");
			pstm.setInt(1, id);
			
			ResultSet rst=pstm.executeQuery();
			while(rst.next()) {
				clg=new Collage(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5), rst.getString(6), rst.getString(7));
				
			}
			pstm.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clg;
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session =req.getSession();
		 User u=(User)session.getAttribute("user");
		 int id=u.getId();
		 String course=req.getParameter("course");
		 String spl=req.getParameter("specialization");
		 String clg=req.getParameter("clg");
		 Double cgpa=Double.parseDouble(req.getParameter("cgpa"));
		 String yop=req.getParameter("complete");
		 String ctype=req.getParameter("ctype");
		 if(getclg(u.getId())==null) {
		 addclg(u,course,spl,clg,cgpa,yop,ctype);
		 }
		 else {
			 addcourse(id, course);
			 addspl(id, spl);
			 addclgname(id, clg);
			 addcgpa(id, cgpa);
			 addyop(id, yop);
			 addtype(id, ctype);
		 }
		 
		req.getRequestDispatcher("update-user.jsp").forward(req, resp);
	}

}
