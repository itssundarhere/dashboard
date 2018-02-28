package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/views")
public class views extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private String test;
  
    public String getTest() {
	return test;
}
public void setTest(String test) {
	this.test = test;
}
	public views() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String sea=request.getParameter("search");
		System.out.println(sea);
		HttpSession session = request.getSession();
		session.setAttribute("dest",sea);
		response.sendRedirect("Setsessionservlet");
			}

}
