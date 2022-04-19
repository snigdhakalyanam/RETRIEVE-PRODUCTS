

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		if((username!=null && username.equals("Snigdha")) && 
			(password!=null && password.equals("12345")) ) {
		HttpSession session=request.getSession();
		session.setAttribute("isLoggedIn", true);
		session.setAttribute("username", username);
		response.sendRedirect("DashboardServlet");
			
		}else {
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("Invalid credentials please try again!");
		out.print("<form action='LoginServlet' method='GET'>");
		out.print("Username : <input type=\"text\" name=\"username\">");
		out.print("Password : <input type=\"text\" name=\"password\">");
		out.print("<button type=\"submit\"> Login </button>");
		out.print("</form>");
		out.print("</body></html>");
		
		}	
	}

	
}
