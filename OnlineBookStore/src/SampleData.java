import java.util.ArrayList;
import java.util.List;

public class SampleData {

	 public static List<Book> getAvailableBooks() {
	        List<Book> availableBooks = new ArrayList<>();
	        
	        // Add sample books
	        availableBooks.add(new Book(1, "Book 1", 10.0));
	        availableBooks.add(new Book(2, "Book 2", 15.0));
	        availableBooks.add(new Book(3, "Book 3", 20.0));
	        
	        return availableBooks;
	    }
}
