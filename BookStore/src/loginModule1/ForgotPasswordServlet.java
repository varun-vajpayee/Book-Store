package loginModule1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3304/bookstore";
	static final String USER = "root";
	static final String PASS = "root";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String email_address = request.getParameter("email_address");
		String phone_Number = request.getParameter("phone_Number");

		System.out.println(phone_Number);
		System.out.println(email_address);

		java.sql.Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Database..");

			java.sql.PreparedStatement pst = null;
			String sql = "SELECT password FROM signuppojo where email_address=? and phone_Number=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, email_address);
			pst.setString(2, phone_Number);
			ResultSet rs = pst.executeQuery();
			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Recover Password</title>");
			out.println(
					"<style>.div {width: 300px; border: 15px solid green;padding: 50px; margin: 20px;}.header {position: absolute;top: calc(50% - 35px);left: calc(50% - 255px);z-index: 2;}.header div {float: left;color: #000000; font-family: 'Exo', sans-serif;font-size: 35px;font-weight: 200;}</style>");
			out.println("</head>");
			out.println(
					"<body style=\"background-image: url('Picture1.jpg');height: 100%; background-position: center; background-repeat: no-repeat; background-size: cover;\">");
			out.println("<div align=\"center\">");
			out.println(
					"<div><p><span><b style=\"color: #F7DC6F; font-family: 'Exo', sans-serif; font-size: 35px;\">Shopping Cart For BookStore</b></span></p></div>");
			out.println("</div>");
			out.println("<br><br><br><br><br><br><br><br><br>");
			out.println("<div align=\"center\" class=\"div\">");
			out.println("<label>");
			out.println("<h2 style=\"color:#F7DC6F\">");

			out.println(" : YOUR PASSWORD IS : ");
			out.println("<strong>");
			while (rs.next()) {
				String pass = rs.getString("password");
				out.println(pass);
			}
			out.println("</strong>");
			out.println("</h2>");
			out.println("</label>");
			out.println("</div>");
			out.println("<div style=\"font-family: 'Exo', sans-serif;\" class=\"clearfix\">");
			out.println("<form action=\"index.html\">");
			out.println("<button type=\"submit\" name=\"Back To Login\" class=\"signup\">");
			out.println(
					"<b	style=\"color: #000000; background-color: #F7DC6F; font-weight: bold; font-family: 'Exo', sans-serif;\">Login Page</b>");
			out.println("</button>");
			out.println("</form>");
			out.println("</div>");
			out.println("</h2>");
			out.println("<div>");
			out.println("<br><br><br><br>" + "<footer align=\"center\" style=\"color: #F7DC6F;\">"
					+ "&copy; Copyright 2019 VarunVajpayee <sup>Tm</sup>" + "</footer>");

			out.println("</div>");
			out.println("</body>");
			out.print("</html>");

		} catch (

		ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}