

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// write our own logic
		Connection conn = null;
		// Create a statement 
		Statement stmt;
		//create a result set
		ResultSet rs = null;
		
		
		// Create a list of books 
		List<Book> books = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/bookdb1";
        String username = "root";
        String password = "mysql";
        
        try {
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	// Connect to the database
        	conn = DriverManager.getConnection(url, username, password);
        	
        	stmt = conn.createStatement();
        	
        	// Execute a SELECT query 
        	rs = stmt.executeQuery("SELECT * FROM books");
        	
        	while(rs.next()) {
        		 int id = rs.getInt("id"); 
        		 String title = rs.getString("title"); 
  			     String author = rs.getString("author"); 
  			     books.add(new Book(id, title, author));
        	}
        }
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
     // Store the list of books in a request attribute 
        request.setAttribute("abc", books);
        
        System.out.println(request.getAttribute("abc"));
		
     // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
