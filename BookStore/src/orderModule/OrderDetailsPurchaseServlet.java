package orderModule;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderDetailsPurchaseServlet")
public class OrderDetailsPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.commonMethod(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.commonMethod(request, response);
	}

	public void commonMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("WELCOME TO ORDER PURCHASE SERVLET 4");

		String vTempOrder_ID = request.getParameter("vTempOrder_ID");
		String vTempCustomer_Name = request.getParameter("customerName");
		String vTempCustomer_Phone = request.getParameter("phone_Number");
		String vTempCustomer_Address = request.getParameter("address1");
		int vTempBook_Quantity = Integer.parseInt(request.getParameter("vTempBook_Quantity"));
		String vTempBook_ID = request.getParameter("vTempBook_ID");
		String vTempOrderDateTime = request.getParameter("vTempOrderDateTime");

		// Printing values for debugging purpose//
		System.out.println(vTempOrder_ID);
		System.out.println(vTempCustomer_Name);
		System.out.println(vTempCustomer_Address);
		System.out.println(vTempCustomer_Phone);
		System.out.println(vTempBook_Quantity);
		System.out.println(vTempBook_ID);
		System.out.println(vTempOrderDateTime);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");

		out.print(
				"<style>h4 {text-align:left;font-style: italic;font-size: 0.8em;color:yellow;font-family: verdana;}</style>");
		out.print("<h4 style=\"color:#F7DC6F;\">Logged in user: " + vTempCustomer_Name + "</h4>");

		out.print(
				"<style>h3 {text-align:center;font-style: italic;font-size: 4em;color:white;font-family: verdana;}</style>");
		out.println("<div align=\"center\">");

		out.println(
				"<div><p><span><b style=\"color: #F7DC6F; font-family: 'Exo', sans-serif; font-size: 35px;\">Shopping Cart For BookStore</b></span></p></div>");
		out.println("<div align=\"center\">");

		out.println("<b>" + "<center>" + "<font color=#F7DC6F size=4>"
				+ "<br><br>Your Order Has Been Confirmed.The Books Shall Be Delivered Within 2 Days..!"
				+ "</b></center>" + "</b>");
		out.println("<b>" + "<center>" + "<font color=\"Yellow\" size=5>"
				+ "<br><br> THANK YOU FOR ONLINE BOOK SHOPPING..!" + "</b></center>" + "</b>");
		out.println("<br> <br> <br> <br> <br><br> <br> <br> <br> <br> <br>"
				+ "<footer align=\"center\" style=\"color: #F7DC6F;\">"
				+ "<i>&copy; Copyright 2019 VarunVajpayee </i><sup>Tm</sup>" + "</footer>");
		out.print("</body></html>");
		out.print(
				"<p align=\"right\" <br><br><a href= 'PageLogin.jsp' style=\"position:absolute; top:40px; left:1300px; color:yellow; font-family:Verdana\">Logout</a></p>");
		out.print("<style>body{background-image: url(\"Picture1.jpg\");\r\n"
				+ "		  		background-repeat: no-repeat;\r\n"
				+ "  				background-size: cover;}</style>");

		try {
			OrderDAO u = new OrderDAO();
			u.addOrderDetails(vTempOrder_ID, vTempCustomer_Name, vTempCustomer_Phone, vTempCustomer_Address,
					vTempBook_Quantity, vTempBook_ID, vTempOrderDateTime);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sessionExpired(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
		PrintWriter out = response.getWriter();
		out.println("<b>" + "<font color=orange size=3>" + "Session expired! Please re-login!" + "</font>");

		rd.include(request, response);
	}
}