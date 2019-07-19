package signUpModule;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookModule.BookDAO;
import bookModule.BookPOJO;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String phone_Number = (String) request.getParameter("phone_Number");
		String password = (String) request.getParameter("password");
		String email_address = (String) request.getParameter("email_address");
		String addressLine1 = (String) request.getParameter("addressLine1");
		String addressLine2 = (String) request.getParameter("addressLine2");
		String city = (String) request.getParameter("city");
		String pinCode = (String) request.getParameter("pinCode");

		SignUpDAO u = new SignUpDAO();
		u.setData(phone_Number, password, email_address, addressLine1, addressLine2, city, pinCode);

		System.out.println("Hello" + " " + phone_Number);
		System.out.println("USERNAME is : " + phone_Number);
		System.out.println("PASSWORD is : " + password);
		System.out.println(email_address);
		System.out.println(addressLine1);
		System.out.println(addressLine2);
		System.out.println(city);
		System.out.println(pinCode);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Book Store</title>");
		out.println("<style>table tr td{font-family:'Exo', sans-serif;border: 1px solid #000000;}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println(
				"<div><p><span><b style=\"color: #F7DC6F; font-family: comic-sans; font-size: 35px;\">Shopping Cart For BookStore</b></span></p></div>");
		out.println("<h3 style=\"color:#F7DC6F\">");
		out.println("<i>" + "HELLO" + " " + phone_Number.toUpperCase() + "</b>");
		out.println("</h3>");
		out.print(
				"<p align=\"right\" <br><br><a href= 'index.html' style=\"position:absolute; top:40px; left:1300px; color:#F7DC6F; font-family: sans-serif\">Logout</a></p>");
		out.println(
				"<table align=\"center\" width=50% style=\"font-family:'Exo', sans-serif;background-color:rgba(0, 0, 0, 0);border: 4px solid gray;color:#F7DC6F;\">");
		out.println("<tr><th>Book Id</th>" + "<th>Book Name</th>" + "<th>Book Author</th>" + "<th>Book Price</th>"
				+ "</tr>");
		BookDAO d = new BookDAO();
		List<BookPOJO> list1 = d.getBooks();
		for (BookPOJO user : list1) {
			out.println(
					"<tr><td align=\"center\" width=\"10%\" style=\"font-family:'Exo', sans-serif;border: 1px solid #000000;color:#F7DC6F;\">"
							+ "<b>" + user.getBookId() + "</b>" + "</td>" + "<td width=\"40%\">" + "<b>"
							+ user.getBookName() + "</b>" + "</td>");
			out.println("<td align=\"center\" width=\"25%\">" + "<b>" + user.getBookAuthor() + "</b>" + "</td>"
					+ "<td align=\"center\" width=\"25%\">" + "<b>" + user.getBookPrice() + "</b>" + "</td>"
					+ "<td><a href='BookDetailsServlet?bookName=" + user.getBookName() + "&phone_Number=" + phone_Number
					+ "'>" + "<b style=\"color:gray\">Purchase</b></a></td>" + "</tr>");
		}
		out.println("</table>");
		out.println(
				"<br> <br> <br> <br> <br> <br> <br> <br> <br>" + "<footer align=\"center\" style=\"color: #F7DC6F;\">"
						+ "&copy; Copyright 2019 VarunVajpayee <sup>Tm</sup>" + "</footer>");

		out.println("</body>");
		out.println("<style>body{background-image: url(\"Picture1.jpg\");"
				+ "  				background-size: cover;	}</style>");

		out.println("</html>");
	}

}
