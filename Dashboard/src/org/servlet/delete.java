package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

@SuppressWarnings("unused")
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String emp=(String) session.getAttribute("emp");
	try {
		
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "");
			Statement st = (Statement) con.createStatement();
			int rs = st.executeUpdate("delete  from employee where fName='"+emp+"'");
			out.println("deleted");
			}
	catch (Exception e2) {
		System.out.println(e2);
	}
	}

}
