import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoveFromCartServlet extends HttpServlet{
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 int bookId = Integer.parseInt(request.getParameter("bookId"));
		 
		 HttpSession session = request.getSession();
	        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
	        if (cart != null) {
	            Iterator<CartItem> iterator = cart.iterator();
	            while (iterator.hasNext()) {
	                CartItem cartItem = iterator.next();
	                if (cartItem.getBook().getId() == bookId) {
	                    iterator.remove();
	                    break;
	                }
	            }
	        }
	        response.sendRedirect("viewCart"); // Redirect to viewCart.jsp after removing
	 }
}
