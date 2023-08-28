import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTestingApp {

	public static void main(String[] args) {
		
		// url, username, pass
		String url = "jdbc:mysql://localhost:3306/JDBC";
		String username = "root";
	    String password = "mysql";
	    
	    try {
	    	//connect to the db
	    	Connection conn = DriverManager.getConnection(url, username, password);
	    	
	    	//creating a statement
	    	Statement stmt = conn.createStatement();
	    	
	    	//execute the statement
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
	    	
	    	 // Iterate over the result set
	    	while(rs.next())
	    	{
	    		int id = rs.getInt("userID");
	    		String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + ", " + name + ", " + email);
	    	}
	    	
	    	//close the resources
	    	rs.close();
	    	stmt.close();
	    	conn.close();
	    
	    }
	    catch(Exception ex) {
	    	System.out.println("exception thrown here:- "+ex.getMessage());
	    }

	}

}
