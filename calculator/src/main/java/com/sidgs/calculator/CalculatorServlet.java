package com.sidgs.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalculatorServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> l=new ArrayList<String>();
		String result=null;
		String op1= request.getParameter("op1");
		String op2= request.getParameter("op2");
		
		String op=request.getParameter("op");
		String n;
		
		CalculatorService cs=new CalculatorService();
		int r=cs.Calculate(op1, op2, op);
		
		result=(op+"("+op1+","+op2+")"+"="+r);
		
		HttpSession session=request.getSession(false);
		
		 
		 response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
		
		if(session!=null) {
			 n=(String)session.getAttribute("uname");
		
			try {
					CalculatorDb cdb=new CalculatorDb();
					cdb.setResult(result, n);
					
		
					int preference=Integer.parseInt(cdb.getPreference(n));
					//if(session.getAttribute("pref")!=null) {
						//int preference=(int) session.getAttribute("pref");
						l=cdb.getResult(n, preference);
					//}
			
			
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
			
				
		pw.println("<html><body><p>");
		pw.println("<a id='a' href=\"user.html\">Click here to manage User preferences</a>");
		pw.println("<div class='topnav-right'><a href=\"logout\">Logout</a></div> ");
		
		pw.println("<table id='table'><tr><th>Previous Results</th></tr>");
		
			for(int i=0; i<l.size(); i++) {
			
				pw.println("<tr><td>"+l.get(i)+"</td></tr>");
			
				}
		pw.println("</table>");
		}
		pw.println("<p><div id='result'>Result is "+r+"</div></p>");
		
		
		
		RequestDispatcher rd= request.getRequestDispatcher("/home.html");
		rd.include(request, response);
		
		}
		
		
		
	}
	
	
	

