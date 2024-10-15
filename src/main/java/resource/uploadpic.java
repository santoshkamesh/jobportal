package resource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.Userdao;
import dto.User;

@WebServlet("/upload")
@MultipartConfig(maxFileSize = 16177215)
public class uploadpic extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session =req.getSession();
			 User u=(User)session.getAttribute("user");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///jobportal","root","tiger");
			
			PreparedStatement pstm=con.prepareStatement("update user set profile_pic=? where id=?");
		
			InputStream ism=null;
	        Part pt= req.getPart("photo");
	 
	        
	        ism= pt.getInputStream();
			pstm.setInt(2, u.getId());
			pstm.setBlob(1, ism);
			
			
			int row=pstm.executeUpdate();
			
			
			System.out.println(row);
			con.close();
			ism.close();
			pstm.close();
			
			try {
				u=Userdao.getuserid(u.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("user", u);
			req.getRequestDispatcher("update-user.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

