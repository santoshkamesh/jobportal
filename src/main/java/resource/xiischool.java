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
import dto.User;
import dto.XiiSchool;


@WebServlet("/xii")
public class xiischool extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		 User u=(User)session.getAttribute("user");
		 int id=u.getId();
		 String board=req.getParameter("board");
		 String meadium=req.getParameter("medium");
		 String yop=req.getParameter("passing_year");
		 Double perc=Double.parseDouble(req.getParameter("percentage"));
		 if(getxii(id)==null) {
		 XiiSchool xii=new XiiSchool(id, board, meadium, yop, perc);
		 addxii(xii);
		 }
		 else {
			 addboard(id, board);
			 addmedium(id, meadium);
			 addperc(id, perc);
			 addyop(id, yop);
		 }
		 req.getRequestDispatcher("update-user.jsp").forward(req, resp);
	}

	private void addxii(XiiSchool xii) {
		Connection connection;
		try {
			connection = Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("insert into xii values(?,?,?,?,?)");
			pstm.setInt(1, xii.getId());
			pstm.setString(2, xii.getBoard());
			pstm.setString(3, xii.getMeadium());
			pstm.setString(4, xii.getYop());
			pstm.setDouble(5,xii.getPerc());
			
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
			PreparedStatement pstm=connection.prepareStatement("update xii set board=? where id=?");
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
			PreparedStatement pstm=connection.prepareStatement("update xii set medium=? where id=?");
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
			PreparedStatement pstm=connection.prepareStatement("update xii set yop=? where id=?");
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
			PreparedStatement pstm=connection.prepareStatement("update xii set perc=? where id=?");
			pstm.setDouble(1, perc);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static XiiSchool getxii(int id) {
		XiiSchool xii=null;
		try {
			
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("select * from xii where id=?");
			pstm.setInt(1, id);
			
			ResultSet rst=pstm.executeQuery();
			while(rst.next()) {
				xii=new XiiSchool(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
				
				
			}
			pstm.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xii;
		
	}

}
