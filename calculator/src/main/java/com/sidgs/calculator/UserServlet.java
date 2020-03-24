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

public class UserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String user;
	String password;
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		 user=req.getParameter("name");
		 password=req.getParameter("password");
		
		
		 res.setContentType("text/html");
		 PrintWriter pw=res.getWriter();
		 
		 HttpSession session=req.getSession();
		 session.setAttribute("uname", user);
		 
		 RequestDispatcher rd=req.getRequestDispatcher("/home.html");
		
		 
		UserDb udb= new UserDb();
		
		User u=udb.validateUser(user, password);
		if(u!=null) {
		pw.println("<html><body>");
		pw.println("<div class='welcome'>Welcome "+"<b>"+user+"</b>");	
		pw.println("</div>");
		
			 pw.println("<a id='a' href=\"user.html\">Click here to manage User preferences</a>");
			 pw.println("<div class='topnav-right'><a href=\"logout\">Logout</a></div> ");
			 
			 List<String> l=new ArrayList<String>();
			 CalculatorDb cdb=new CalculatorDb();
			  int preference=Integer.parseInt(cdb.getPreference(user));
			 l=cdb.getResult(user, preference);
			 
			 pw.println("<table id='table'><tr><th>Previous Results</th></tr>");
				
				for(int i=0; i<l.size(); i++) {
				
					pw.println("<tr><td>"+l.get(i)+"</td></tr>");
				
					}
			pw.println("</table>");
			pw.println("</body></html>");
		
		 rd.include(req, res);
		 
		
		}else pw.println("<div>The username or password entered is incorrect!</div>");
		pw.println("</body></html>");
		
	
		
	}

	
	
}
