package orderModule;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {
	// Added serialVersionUID to avoid warning
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.commonMethod(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.commonMethod(request, response);
	}

	public void commonMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");

		System.out.println("WELCOME TO ORDER DETAILS SERVLET 3");
		// Getting todays date and time//
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String vTempOrderDateTime = dateFormat.format(date);

		// Generating Order_ID by using Random() function//
		Random rand = new Random();
		String vTempOrder_ID = "Ord00" + rand.nextInt(1000);

		// Getting values from session variables//
		int vTempBook_Quantity = Integer.parseInt(request.getParameter("bookQuantity"));
		String vTempBook_ID = request.getParameter("bookId");
		String vTempBook_Name = request.getParameter("bookName");
		String vTempBook_Author = request.getParameter("bookAuthor");
		long vTempBook_Price = Long.parseLong(request.getParameter("bookPrice"));
		long vTempTotalPrice = vTempBook_Quantity * vTempBook_Price;

		HttpSession session = request.getSession(false);
		String n = (String) session.getAttribute("phone_Number");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.print("<html><form action='OrderDetailsPurchaseServlet?vTempOrder_ID=" + vTempOrder_ID
				+ "&vTempBook_Quantity=" + vTempBook_Quantity + "&vTempBook_ID=" + vTempBook_ID + "&vTempOrderDateTime="
				+ vTempOrderDateTime + "'method=post>");
		out.print(
				"<style>h4 {text-align:left;font-style: italic;font-size: 0.8em;color:yellow;font-family: verdana;}</style>");
		out.print("<h4>Logged in user: " + n + "</h4>");

		out.print(
				"<body><style>h3 {text-align:center;font-style: italic;font-size: 4em;color:white;font-family: verdana;}</style>");
		out.println("<div align=\"center\">");

		out.println(
				"<div><p><span><b style=\"color: #F7DC6F; font-family: 'Exo', sans-serif; font-size: 35px;\">Shopping Cart For BookStore</b></span></p></div>");
		out.println("</div>");

		out.print("<h1 align='center' style='color:#F7DC6F'>Order Summary</h1>");
		out.println(
				"<table align=\"center\" width=50% style=\"font-family:'Exo', sans-serif;background-color:#000000;border: 4px solid gray;color:#F7DC6F;\">");

		out.print(
				"<tr><td style='color:#F7DC6F;'>Customer Name:</td><td><input type='text' style=\"Background-color:#F7DC6F;color:#000000;\" name='customerName' id='customerName' required='required' placeholder='Enter Customer Name...'></td></tr>");
		out.print(
				"<tr><td style='color:#F7DC6F;'>Address:</td><td><input type='text' style=\"Background-color:#F7DC6F;color:#000000;\" name='address1' id='address1' required='required' placeholder='Enter Customer Address...'></td></tr>");
		out.print(
				"<tr><td style='color:#F7DC6F;'>Phone No:</td><td><input type='text' style=\"Background-color:#F7DC6F;color:#000000;\" name='phone_Number' id='phone_Number' required='required' placeholder='Enter Customer Phone no...'></td></tr>");
		out.print("<tr><td style='color:#F7DC6F;'>Your Order Details are:</td></tr>");
		out.print("<tr><td style='color:#F7DC6F;'>Order ID:</td><td style='color:#F7DC6F;'>" + vTempOrder_ID
				+ "</td></tr>");
		out.print("<tr><td style='color:#F7DC6F;'>Order Date:</td><td style='color:#F7DC6F;'>" + vTempOrderDateTime
				+ "</td></tr>");
		out.print("<tr><td style='color:#F7DC6F;'>Book ID:</td><td style='color:#F7DC6F;'>" + vTempBook_ID
				+ "</td></tr>");
		out.print("<tr><td style='color:#F7DC6F;'>Book Name:</td><td style='color:#F7DC6F;'>" + vTempBook_Name
				+ "</td></tr>");
		out.print("<tr><td style='color:#F7DC6F;'>Book Author:</td><td style='color:#F7DC6F;'>" + vTempBook_Author
				+ "</td></tr>");
		out.print("<tr><td style='color:#F7DC6F;'>Book Quantity:</td><td style='color:#F7DC6F;'>" + vTempBook_Quantity
				+ "</td></tr>");
		out.print("<tr><td style='color:#F7DC6F;'>Book Price:</td><td style='color:#F7DC6F;'>" + vTempBook_Price
				+ "</td></tr>");
		out.print("<tr><td style='color:#F7DC6F;'>Total price:</td><td style='color:#F7DC6F;'>" + vTempTotalPrice
				+ "</td></tr>");
		out.print("</table>");
		out.print("<br>");

		out.print("<p align='center'>");
		out.print(
				"<input type='submit' value='Confirm' style=\"Background-color:#F7DC6F;color:#000000;\"> &nbsp;&nbsp;&nbsp;");
		out.print(
				"<input type='submit' value='Cancel' style=\"Background-color:#F7DC6F;color:#000000;\" formaction='index.html' >");
		out.print("</p>");

		out.print("<br><br></body></form>");

		out.print("<style>body{background-image: url(\"Picture1.jpg\");\r\n"
				+ "		  		background-repeat: no-repeat;\r\n"
				+ "  				background-size: cover;}</style>");
		out.println("<br>" + "<footer align=\"center\" style=\"color: #F7DC6F;\">"
				+ "&copy; Copyright 2019 VarunVajpayee <sup>Tm</sup>" + "</footer>");
		out.print("</html>");
	}

	public void sessionExpired(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
		PrintWriter out = response.getWriter();
		out.println("<b>" + "<font color=orange size=3>" + "Session expired! Please re-login!" + "</font>");

		rd.include(request, response);
	}
}