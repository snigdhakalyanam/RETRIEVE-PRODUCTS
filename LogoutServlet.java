

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session !=null) {
			
			if(session.getAttribute("username") != null) {
				String username=(String) session.getAttribute("username");
				boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
				session.removeAttribute("username");
				session.removeAttribute("isLoggedIn");
				response.sendRedirect("LoginServlet");
		
			
			} 
				
			}
			
			
		
		}
		
		
		
		
		
		
	}

	


