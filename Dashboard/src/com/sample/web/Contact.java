package com.sample.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean logged = false;
		Cookie[] cookie = request.getCookies();
		if (cookie != null) {
			for (Cookie cookie1 : cookie) {
				if (cookie1.getName().equals("Auth_user")) {
					logged = true;
					break;
				}
			}
		}
		if (logged) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root",
						"");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from data");
				while (rs.next()) {
					out.println("<!DOCTYPE html>");
					out.println("<html lang=\"en\">");
					out.println("<head>");
					out.println("<title>Contact</title>");
					out.println(" <meta charset=\"utf-8\">");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
					out.println(
							" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
					out.println(
							"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
					out.println(
							" <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
					out.println("	</head>");
					out.println("<body>");
					out.println("<table class=\"table-bordered\" style =\"width:100%; border:1px solid black;\" >");
					out.println("  <tr>");
					out.println("     <td>Username</td>");
					out.println("     <td>FullName</td>");
					out.println("     <td>email-Id</td>");
					out.println("  </tr>");
					out.println("  <tr>");
					out.println("     <td>" + rs.getString("email") + "</td>");
					out.println("     <td>" + rs.getString("fullname") + "</td>");
					out.println("     <td>" + rs.getString("email") + "</td>");
					out.println("  </tr>");
					out.println(" </table>");
					out.println("</body>");
					out.println("</html>");
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		} else {
			out.println("Invalid Username or Password");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
