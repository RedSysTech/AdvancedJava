import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCartServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		 List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		 
		 if (cart == null) {
	            cart = new ArrayList<>();
	            session.setAttribute("cart", cart);
	        }
		// Process selected books
		 String[] selectedBooksArray =  request.getParameterValues("selectedBooks");
		 if (selectedBooksArray != null) {
			 for (String selectedBook : selectedBooksArray) {
				 String[] bookInfo = selectedBook.split(",");
				 if (bookInfo.length == 3) {
					 int bookId = Integer.parseInt(bookInfo[0]);
	                 String title = bookInfo[1];
	                 double price = Double.parseDouble(bookInfo[2]);
	                 
	              // Add selected book to the cart
	                 Book book = new Book(bookId, title, price);
	                 CartItem cartItem = new CartItem();
	                 cartItem.setBook(book);
	                 cartItem.setQuantity(1);
	                 cart.add(cartItem);
				 }
			 }
		 }
		 response.sendRedirect("viewCart"); // Redirect to viewCart.jsp after adding
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
	}
}
