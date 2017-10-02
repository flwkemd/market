package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id == null || id.equals("") || pw == null || pw.equals("")) {
			response.sendRedirect("login.jsp");
			return;
		}
		int result = new UserDAO().login(id, pw);
		if(result == 1) {
			request.getSession().setAttribute("id", id);
			response.sendRedirect("index.jsp");
		}else if(result == 2) {
			response.sendRedirect("login.jsp");
		}else if(result == 0) {
			response.sendRedirect("login.jsp");
		}else if(result == -1) {
			response.sendRedirect("login.jsp");
		}
	}

}
