package resource;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import dto.User;


@WebServlet("/personal")
public class Personal extends HttpServlet{
	 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session =req.getSession();
		 User u=(User)session.getAttribute("user");
		 String name=req.getParameter("fname");
		 String email=req.getParameter("mail");
		 String gender=req.getParameter("gender");
		 long phone=Long.parseLong(req.getParameter("mobo"));
		 String dob=req.getParameter("udob");
		 String ws=req.getParameter("wexp");
			Userdao.updateusername(u, name);
			Userdao.updateuseremail(u, email);
			Userdao.updateusergender(u, gender);
			Userdao.updateuserphone(u, phone);
			Userdao.userdobupdate(u, dob);
			Userdao.updateuserworkexp(u, ws);
		try {
			u=Userdao.getuserid(u.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("user", u);
		req.getRequestDispatcher("update-user.jsp").forward(req, resp);
	}
}
