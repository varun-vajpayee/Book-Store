package bookModule;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/BookDetailsServlet")
public class BookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		System.out.println("WELCOME TO BOOK DETAILS SERVLET 2");
		// Get the SelectedBook_ID or SelectedBook_Name from "BookServlet"//
		request.getAttribute("bookName");

		String VSelectedBook_Name = request.getParameter("bookName");
		String phone_Number = request.getParameter("phone_Number");
		// SESSION TRACKING USING HTTP SESSION
		HttpSession session = request.getSession();
		session.setAttribute("phone_Number", phone_Number);

		System.out.println("bookName : " + VSelectedBook_Name);
		if (VSelectedBook_Name != null) {
			Configuration conf = new Configuration();
			conf.configure("hib.cfg.xml");
			SessionFactory sf = conf.buildSessionFactory();
			Session s = sf.openSession();

			List<BookPOJO> bookList = null;
			String hql;
			// HQL
			hql = "from BookPOJO b where b.bookName='" + VSelectedBook_Name + "'";

			org.hibernate.query.Query<BookPOJO> query = s.createQuery(hql, BookPOJO.class);
			bookList = query.list();

			for (BookPOJO b : bookList) {
				System.out.println(b.getBookId());
				System.out.println(b.getBookAuthor());
				System.out.println(b.getBookName());
				System.out.println(b.getBookPrice());
			}

			PrintWriter out = response.getWriter();
			out.println("<p style=\"color:#F7DC6F\">");
			out.println("Book Name : " + VSelectedBook_Name);
			out.println("</p>");
			for (BookPOJO b : bookList) {
				// HTML STARTING POINT
				out.print("<html><form action='OrderDetailsServlet' method='post'>");
				out.print(
						"<style>h4 {text-align:left;font-style: italic;font-size: 0.8em;color:yellow;font-family: verdana;}</style>");
				out.print("<h4 style=\"color:#F7DC6F;\"> Logged in user: " + phone_Number + "</h4>");

				out.print("<body>");
				out.println("<div align=\"center\">");
				out.println(
						"<div><p><span><b style=\"color: #F7DC6F; font-family: 'Exo', sans-serif; font-size: 35px;\">Shopping Cart For BookStore</b></span></p></div>");
				out.println("</div>");
				out.print(
						"<p align=\"right\" <br><br><a href= 'index.html' style=\"position:absolute; top:40px; left:1300px; color:#F7DC6F; font-family: sans-serif\">Logout</a></p>");

				out.println(
						"<table align=\"center\" width=50% style=\"font-family:'Exo', sans-serif;background-color:#000000;border: 4px solid gray;color:#F7DC6F;\">");

				out.print("<tr><th>Book ID</th>" + "<th>Book Name</th>" + "<th>Book Author</th>" + "<th>Book Price</th>"
						+ "<th>Book Quantity</th>" + "</tr>");

				out.print(
						"<tr><b><td><input type='text' width='10' id='bookId' name='bookId' style='background-color:#000000; color:#F7DC6F;' readonly='readonly' value="
								+ b.getBookId() + ">");
				out.print(
						"</td><td><input type='text' width='100' id='bookName' name='bookName' style='background-color:#000000;color:#F7DC6F;' readonly='readonly' value='"
								+ b.getBookName() + "'>");
				out.print(
						"</td><td><input type='text' width='50' id='bookAuthor' name='bookAuthor' style='background-color:#000000; color:#F7DC6F;' readonly='readonly' value='"
								+ b.getBookAuthor() + "'>");
				out.print(
						"</td><td><input type='text' width='5' id='bookPrice' name='bookPrice' style='background-color:#000000; color:#F7DC6F;' readonly='readonly' value="
								+ b.getBookPrice() + ">");
				out.print(
						"</td><td><input type='number' width='5' id='bookQuantity' name='bookQuantity' style='background-color:#F7DC6F; color:#000000;' value=1 </td></tr>");
				out.print("</table>");
				out.print("<br><br><br><br>");
				// PURCHASE BUTTON
				out.print("<p align='center'>");
				out.print("<button type='submit'>Purchase</button>");
				out.print("</body></form>");
				// CANCEL BUTTON
				out.print("<form action='LoginServlet' method='post'align='center'");
				out.print("<body><button type='submit'>Cancel</button>");
				out.print("</body></form>");
				out.print("</p>");
				out.print("<style>body{background-image: url(\"Picture1.jpg\");" + "background-repeat: no-repeat;"
						+ "  				background-size: cover;</style>");
				// FOOTER
				out.println("<br> <br> <br> <br> <br> <br> <br> <br> <br>"
						+ "<footer align=\"center\" style=\"color: #F7DC6F;\">"
						+ "&copy; Copyright 2019 VarunVajpayee <sup>Tm</sup>" + "</footer>");
				out.print("</html>");
				out.close();
			}
		}
	}

}
