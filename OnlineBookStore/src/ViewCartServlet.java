import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
	        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
	        
	        if (cart == null) {
	            cart = new ArrayList<>();
	            session.setAttribute("cart", cart);
	        }
	        
	        List<Book> availableBooks = SampleData.getAvailableBooks();
	        
	     // Add availableBooks to the request attribute
	        request.setAttribute("availableBooks", availableBooks);
	        
	     // Forward to viewCart.jsp
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewCart.jsp");
	        dispatcher.forward(request, response);
	}
}
