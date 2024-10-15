package resource;

import java.io.IOException;
import java.sql.Connection;
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
import dto.XSchool;


@WebServlet("/x")
public class Xschooldao extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		 User u=(User)session.getAttribute("user");
		 int id=u.getId();
		 String board=req.getParameter("board");
		 String meadium=req.getParameter("medium");
		 String yop=req.getParameter("passing_year");
		 Double perc=Double.parseDouble(req.getParameter("percentage"));
		 if(getx(id)==null) {
		 XSchool x=new XSchool(id, board, meadium, yop, perc);
		 addx(x);
		 }
		 else {
			 addboard(id, board);
			 addmedium(id, meadium);
			 addperc(id, perc);
			 addyop(id, yop);
		 }
		 req.getRequestDispatcher("update-user.jsp").forward(req, resp);
	}

	private void addx(XSchool x) {
		Connection connection;
		try {
			connection = Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("insert into x values(?,?,?,?,?)");
			pstm.setInt(1, x.getId());
			pstm.setString(2, x.getBoard());
			pstm.setString(3, x.getMeadium());
			pstm.setString(4, x.getYop());
			pstm.setDouble(5,x.getPerc());
			
			pstm.executeUpdate();
			
			
			pstm.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void addboard(int id,String board) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("update x set board=? where id=?");
			pstm.setString(1, board);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void addmedium(int id,String medium) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("update x set medium=? where id=?");
			pstm.setString(1, medium);
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
			PreparedStatement pstm=connection.prepareStatement("update x set yop=? where id=?");
			pstm.setString(1, yop);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void addperc(int id,double perc) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("update x set perc=? where id=?");
			pstm.setDouble(1, perc);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static XSchool getx(int id) {
		XSchool x=null;
		try {
			
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("select * from x where id=?");
			pstm.setInt(1, id);
			
			ResultSet rst=pstm.executeQuery();
			while(rst.next()) {
				x=new XSchool(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}

}
