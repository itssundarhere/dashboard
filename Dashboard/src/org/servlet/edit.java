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
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String dest=(String) session.getAttribute("dest");
		Integer id = Integer.valueOf(request.getParameter("cid"));
		String emp=String.valueOf(id);
//String h=request.getParameter("emailid");
//out.println(h);
		System.out.println(dest);
		//out.println(id);
				try{
			//System.out.println(emp);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "");
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery("select * from user_DB where empId='" + emp + "'");
			System.out.println("try"+emp);
			while (rs.next()) {
			System.out.println(emp);
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"en\">");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\" ></link>");
			out.println("<title>view</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form method=\"get\" action=\"Setsessionservlet\">");

			//out.println(" <label>Id</label>");
			   out.println("<div class=\"container\">");
			   out.println("<div align=\"center\" style=\"width:900px;margin:130px auto\">");
			   out.println("<div class=\"form-group\" style=\"width: 350px;padding-left: 5%\">");
			   out.println("<h3>User profile</h3>");
			   out.println(" <label>Id</label>");
			   out.println("<input type=\"text\" class=\"form-control\" name=\"empid\"id=\"empid\" value="+rs.getString("empId")+" disabled>");
			   out.println("<label>FirstName</label>");
			   out.println("<input type=\"text\" class=\"form-control\" name=\"fname\"id=\"fname\" value="+rs.getString("fName")+" disabled>");
			   out.println(" <label>LastName</label>");
			   out.println("<input type=\"text\" class=\"form-control\" name=\"lname\"id=\"lname\" value="+rs.getString("lName")+" disabled>");
			    
			   out.println("<label>EmailId</label>");
			   out.println("<input type=\"text\" class=\"form-control\" name=\"emailid\"id=\"emailid\" value="+rs.getString("email")+" disabled>");
			   out.println("<label>PhoneNumber</label>");
			   out.println("<input type=\"text\" class=\"form-control\" name=\"phone\"id=\"phone\" value="+rs.getString("phone")+" disabled>");
			   out.println("<label>DateOfBirth</label>");
			   out.println("<input type=\"text\" class=\"form-control\" name=\"dob\"id=\"dob\" value="+rs.getString("dob")+" disabled>");
			   out.println("<label>Designation</label>");
			   //out.println(dest);
			   out.println("<input  class=\"form-control\" name=\"designation\"id=\"designation\" value="+dest+" disabled>");
			   out.println("<label>Location</label>");
			   out.println("<input type=\"text\" class=\"form-control\" name=\"location\"id=\"location\" value="+rs.getString("location")+" disabled>");
			   out.println("<br><button type=\"submit\" class=\"btn btn-success\">Back</button>");
			   out.println("</div>");
			   //out.println("<div class=\"container\" >");
			   
			   //out.println("</div>");
			   out.println("</div>");
			   out.println("</form>");
			   out.println("</body>");
			   out.println("</html>");
			}
		}
		catch(Exception e){
			
		}

	}

}
