package com.realcoderz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import dbconfig.DatabaseConnectivity;

public class UserTableServlet extends HttpServlet
{
	    private static final long serialVersionUID = 1L;
    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();  
	           
	         out.println("<html><body>");
	         try
	         {
	        	 Connection connection=DatabaseConnectivity.getdata();
	     		 Statement statement=(Statement) connection.createStatement();
 
	             ResultSet rs = statement.executeQuery("select * from user"); 
	             out.println("<table border=1 width=70% height=50%>");  
	             out.println("<tr><th>User Id<th>User Name<th>User Address<th>User Number</th><th>User Email<th>User Password</tr><th>");  
	             while (rs.next()) 
	             {  
	            	    Integer userId=rs.getInt("USER_ID");
	            		String uname=rs.getString("NAME");
	            		String uaddress=rs.getString("ADDRESS");
	            		String unumber=rs.getString("NUMBER");
	            		String umail=rs.getString("EMAIL");
	            		String upassword=rs.getString("PASSWORD");
	            	 
	                    out.println("<tr><td>" + userId + "</td><td>" + uname + "</td><td>" + uaddress+ "</td><td>" + unumber+ "</td><td>" + umail+ "</td><td>" + upassword + "</td></tr>");   
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
