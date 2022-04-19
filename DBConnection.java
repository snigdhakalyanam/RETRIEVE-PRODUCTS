import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	
	private Connection connection = null;
	public DBConnection(String url, String user, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() {
		if(connection !=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
}
