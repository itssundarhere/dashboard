package com.sample.web;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class SigninValidate
 */
@WebServlet("/SigninValidate")
public class SigninValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SigninValidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String uname = request.getParameter("user");
		String password = request.getParameter("pass");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select * from data where email='" + uname + "'and password='" + password + "'");
			while (rs.next()) {
				
				 //out.println(uname);
				 //out.println(password);
				 //out.println("login success");
				 response.sendRedirect("Activity.html"); 
				/*Cookie cookie = new Cookie("Auth_user", uname);
				response.addCookie(cookie);
				response.sendRedirect("Contact");
				*/
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}
}
