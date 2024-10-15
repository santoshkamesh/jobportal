package resource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;



@WebServlet("/viewpic")
public class viewpic extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		byte[] img =null;
		ServletOutputStream sos=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql:///jobportal","root","tiger");
			PreparedStatement pstm=connection.prepareStatement("select * from user where id=?");
			pstm.setInt(1, user.getId());
			ResultSet rst=pstm.executeQuery();
			int i=0;
//			System.out.println(i);
			if(rst.next()) {
				i=1;
				img=rst.getBytes(8);
				
				
			}
			rst.close();
			connection.close();
//			System.out.println(i);
			if(img!=null&&i==1) {

				
				sos=resp.getOutputStream();
				sos.write(img);
			}
			else {
				connection=DriverManager.getConnection("jdbc:mysql:///school","root","tiger");
				Statement st=connection.createStatement();
				ResultSet r=st.executeQuery("select * from profilepic where id=0");
				byte[] j=null;
				if(r.next()) {
				j=r.getBytes(3);
				}
				sos=resp.getOutputStream();
				sos.write(j);
				st.close();
				connection.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

