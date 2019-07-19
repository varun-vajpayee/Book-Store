package bookModule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookInsertServlet")
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//GETTING THE REQUIRED PARAMETER 
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));

		System.out.println(bookId);
		System.out.println(bookName);
		System.out.println(bookAuthor);
		System.out.println(bookPrice);

		BookDAO d = new BookDAO();
		d.setBooks(bookId, bookName, bookAuthor, bookPrice);
	}

}
