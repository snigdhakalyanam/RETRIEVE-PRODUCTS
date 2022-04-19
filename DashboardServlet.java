

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DashboardServlet extends HttpServlet {
	
	
	private DBConnection dbConnection = null;
	
   public void init() throws ServletException {
	   super.init();
	   InputStream inStream = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
	   Properties props = new Properties();
	   try {
		props.load(inStream);
		
		String url=props.getProperty("url");
		String user=props.getProperty("user");
		String password=props.getProperty("password");
		dbConnection = new DBConnection(url, user, password);

		
		
		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
   
   
   }
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		if(session!=null) {
			if(session.getAttribute("username")!=null) {
				String username = (String) session.getAttribute("username");
				boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
				if(isLoggedIn) {
				out.print("Welcome, "+ username + " <br>");
				out.print("<a href='LogoutServlet'>Logout </a>"+ "<br>");
				
					//Display Products
				
				
				Connection connection = dbConnection.getConnection();
				if(connection!=null) {
					try {
						Statement statement = connection.createStatement();
						String query="select * FROM eproduct";
						ResultSet resultset = statement.executeQuery(query);
						while(resultset.next()) {
							out.print(resultset.getInt("ID") +" "+ resultset.getString("name") +" "+ 
									resultset.getFloat("price") +" "+ resultset.getDate("date_added") +"<br>");
							
						
					}
						
						
						resultset.close();
						statement.close();
						dbConnection.closeConnection();
						
						
						
						
						} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				
				}
				
			}else {
				
				response.sendRedirect("LoginServlet");
				
		
		}
			
			
				
				
				
			
		
		}
		
		
	

		
		
	}}

	
	


