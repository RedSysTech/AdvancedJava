import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private Map<String, String> users;
	
	 public void init() throws ServletException {
	        users = new HashMap<>();
	        users.put("user1", "password1");
	        users.put("user2", "password2");
	    }
	 
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 String username = request.getParameter("username");
	     String password = request.getParameter("password");
	        
	     if (users.containsKey(username) && users.get(username).equals(password)) {
	    	 HttpSession session = request.getSession();
	    	 session.setAttribute("username", username);
	    	 response.sendRedirect("viewCart");
	     }else {
	            response.sendRedirect("index.jsp");
	      }
	 }
}
