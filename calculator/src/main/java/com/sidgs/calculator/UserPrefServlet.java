package com.sidgs.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserPrefServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s=request.getParameter("customize");	
		int customize=0;
		List<String> l=new ArrayList<String>();
		HttpSession session=request.getSession(false);
		
		customize=Integer.parseInt(s);
		String uname= (String) session.getAttribute("uname");
		
		
		UserDb udb=new UserDb();
		udb.setPreference(customize, uname);
		
		CalculatorDb cdb=new CalculatorDb();
		l=cdb.getResult(uname, customize);
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><body><p>");
		pw.println("<a id='a' href=\"user.html\">Click here to manage User preferences</a>");
		 pw.println("<div class='topnav-right'><a href=\"logout\">Logout</a></div> ");
		pw.println("</p><table id='table'><tr><th>Previous Results</th></tr>");
		for(int i=0; i<l.size(); i++) {
			
			pw.println("<tr><td>"+l.get(i)+"</td></tr>");
			
		}
		pw.println("</table></body></html>");
		
		
		
		session.setAttribute("pref", customize);
		
		RequestDispatcher rd=request.getRequestDispatcher("/home.html");
		rd.include(request, response);
		pw.close();
	}
	
	
}
