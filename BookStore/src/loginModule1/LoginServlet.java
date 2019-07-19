package loginModule1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookModule.BookDAO;
import bookModule.BookPOJO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("WELCOME TO LOGIN SERVLET 1");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String pn = (String) request.getParameter("phone_Number");
		String pw = (String) request.getParameter("password");

		if (LoginDAO.checkCredentials(pn, pw)) {

			System.out.println("Hello" + " " + pn);
			System.out.println("USERNAME is : " + pn);
			System.out.println("PASSWORD is : " + pw);
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Book Store</title>");
			out.println("<style>table tr td{font-family:'Exo', sans-serif;border: 1px solid #000000;}</style>");
			out.println("</head>");
			out.println("<body>");

			out.println("<div align=\"center\">");

			out.println(
					"<div><p><span><b style=\"color: #F7DC6F; font-family: comic-sans; font-size: 35px;\">Shopping Cart For BookStore</b></span></p></div>");
			out.println("<h3 style=\"color:#F7DC6F\">");
			out.println("</div>");
			out.println(
					"<h4 style=\"color:#F7DC6F;\"><i>" + "<b>" + "HELLO" + " " + pn.toUpperCase() + "</i>" + "</b>");
			out.println("</h3>");
			out.print(
					"<p align=\"right\" <br><br><a href= 'index.html' style=\"position:absolute; top:40px; left:1300px; color:#F7DC6F; font-family: sans-serif\">Logout</a></p>");
			out.println(
					"<table align=\"center\" width=50% style=\"font-family:'Exo', sans-serif;background-color:#000000;border: 4px solid gray;color:#F7DC6F;\">");
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
						+ "<td><a href='BookDetailsServlet?bookName=" + user.getBookName() + "&phone_Number=" + pn
						+ "'>" + "<b style=\"color:gray\">Purchase</b></a></td>" + "</tr>");
			}
			out.println("</table>");
			out.println("<br> <br> <br> <br> <br> <br> <br> <br> <br>"
					+ "<footer align=\"center\" style=\"color: #F7DC6F;\">"
					+ "&copy; Copyright 2019 VarunVajpayee <sup>Tm</sup>" + "</footer>");

			out.println("</body>");
			out.println("<style>body{background-image: url(\"Picture1.jpg\");"
					+ "  				background-size: cover;	}</style>");

			out.println("</html>"); ////////////////
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("SignUp.html");
			rs.include(request, response);
		}

	}
}
