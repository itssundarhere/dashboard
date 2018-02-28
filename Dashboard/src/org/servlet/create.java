package org.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.emp.UserDatabase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



@WebServlet("/create")
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public create() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		//out.println("created");
		
		String eid = request.getParameter("empid");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("emailid");
		String phone = request.getParameter("phone");
		long ph=Long.parseLong(phone);
		String dob = request.getParameter("dob");
		
		Date date= new Date(dob);
		String desg = request.getParameter("designation");
		String loc = request.getParameter("location");
	
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		UserDatabase emp=new UserDatabase();
		emp.setEmpId(eid);
		emp.setfName(fname);
		emp.setlName(lname);
		emp.setEmail(email);
		emp.setPhone(ph);
		emp.setDob(date);
		emp.setDesignation(desg);
		emp.setLocation(loc);
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		sf.close();
		response.sendRedirect("show.html");
	}

}
