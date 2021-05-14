package com.realcoderz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

import dbconfig.DatabaseConnectivity;
import pojoClass.CompanyClass;
import user.CompanyDAOImpl;

public class CompanyServlet extends HttpServlet
{
	static final Logger LOGGER = Logger.getLogger(CompanyServlet.class);
	
	private static final long serialVersionUID= 1L;
	CompanyDAOImpl di=new CompanyDAOImpl();
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			LOGGER.info("This is a logging statement from log4j");
	    PrintWriter pw=response.getWriter();
	   
	    String cname=request.getParameter("name");
	    String caddress=request.getParameter("address");
	    String cnumber=request.getParameter("phone");
	    
	    CompanyClass company=new CompanyClass();
	    company.setCompanyName(cname);
	    company.setCompanyAddress(caddress);
	    company.setCompanyNumber(cnumber);
	    
	    String html = "<html><h2>Company values added successfully!</h2></html>";
		response.getWriter().println(html);	    

	    try {
	    	response.sendRedirect("welcome.html");
			di.insertCompany(company);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			PrintWriter out = response.getWriter();  
	         //response.setContentType("companyTable.html");  
	         out.println("<html><body>");
	         try
	         {
	        	 Connection connection=DatabaseConnectivity.getdata();
	     		 Statement statement=(Statement) connection.createStatement();
  
	             ResultSet rs = statement.executeQuery("select * from company"); 
	             out.println("<table border=1 width=50% height=50%>");  
	             out.println("<tr><th>Company Name</th><th>Company Address</th><th>Company Phone</th><tr>");  
	             while (rs.next()) 
	             {  
	                 String name = rs.getString("Name");  
	                 String address = rs.getString("Address");
	                 String number = rs.getString("Phone");
	                   
	                 out.println("<tr><td>" + name + "</td><td>" + address + "</td><td>" + number + "</td></tr>");   
	             }  
	             out.println("</table>");  
	             out.println("</html></body>");  
	             connection.close(); 
	         }
	         catch(Exception e)
	         {
	        	 System.out.println(e);
	         }
		}
}
