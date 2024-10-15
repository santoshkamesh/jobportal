package resource;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Jobdao;
import dto.Job;


@WebServlet("/jobview")
public class ViewJob extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Job job=Jobdao.getjob(id);
		req.setAttribute("job", job);
		req.getRequestDispatcher("viewjob.jsp").forward(req, resp);
		
		
	}
}
