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

/**
 * Servlet implementation class Setsessionservlet
 */
@WebServlet("/Setsessionservlet")
public class Setsessionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Setsessionservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String dest = (String) session.getAttribute("dest");
		System.out.println(dest);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\" >");
		out.println("<title>view</title>");
		out.println("<body>");
		out.println("<form method=\"post\" action=\"edit\">");

		out.println("<div class=\"container\">");
		out.println("<table class=\"table table-bordered\" style =\"width:900px;margin:90px auto\">");
		out.println("    <thead>");
		out.println("    <tr>");
		out.println("  <th>EMPLOYEE-ID</th>");
		out.println(" <th>FIRSTNAME</th>");
		out.println(" <th>LASTNAME</th>");
		out.println("  <th>EMAIL</th>");
		out.println(" <th>PHONE</th>");
		out.println(" <th>DOB</th>");
		out.println(" <th>DESIGNATION</th>");
		out.println(" <th>LOCATION</th>");
		out.println("  </tr>");
		out.println("   </thead>");
		out.println(" <tbody style =\"width:350px\">");
		
		String empid;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "");
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery("select * from user_DB where designation='" + dest + "'");
			// System.out.println("emp"+emp);

			while (rs.next()) {

				//out.println("<tr>");
				//out.println(" <td>" + rs.getString("empid") + "</td>");

				empid = rs.getString("empid");

				out.println("<tr><td>"+rs.getString("empid") + "</td><td>" + rs.getString("fName") + "</td><td>" + rs.getString("lName")
				+ "</td><td>" + rs.getString("email") +"</td><td>"+rs.getString("phone") +"</td><td>"+rs.getString("dob")+"</td><td>"+rs.getString("designation") +"</td><td>"+rs.getString("location")+"</td><td><a  class=\"btn btn-success\"href='edit?cid=" + rs.getString("empid")
				+ "'>View Profile</a> </td></tr>");
				
				
				// request.setAttribute("empid",rs.getString("empid"));
				/*out.println("<td>" + rs.getString("fName") + "</td>");
				out.println(" <td>" + rs.getString("lName") + "</td>");
				out.println(" <td>" + rs.getString("email") + "</td>");
				out.println(" <td>" + rs.getString("phone") + "</td>");
				out.println(" <td>" + rs.getString("dob") + "</td>");
				out.println(" <td>" + rs.getString("designation")+"</td>");
				out.println(" <td>" + rs.getString("location") + "</td>");
				<td><a href='delete?cid=" + contact.getId()+ "'>remove</a>*/
				//out.println(" <td>" + "<button type=\"submit\" class=\"btn btn-success\">View Profile</button>" + "</td>");
				//out.println(" <td>" + "<a href=\"http://localhost:8081/crud/delete\" type=\"submit\" class=\"btn btn-danger\">Delete</button>"+ "</td>");
				//out.println("</tr>");

			}
			out.println(" </tbody>");
			out.println(" </table>");
			out.println("</div>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

}
