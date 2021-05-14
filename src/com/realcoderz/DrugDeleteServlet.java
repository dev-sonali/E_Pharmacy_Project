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

import com.mysql.jdbc.Statement;

import dbconfig.DatabaseConnectivity;
import pojoClass.DrugClass;
import user.DrugDAOImpl;

public class DrugDeleteServlet extends HttpServlet
{
	private static final long serialVersionUID= 1L;
	DrugDAOImpl di=new DrugDAOImpl();
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			System.out.println("Inside Post");
	    PrintWriter pw=response.getWriter();
	    	    
	    int dbarcode=Integer.parseInt(request.getParameter("barcode"));
	    	    	    
	    DrugClass drug=new DrugClass();
	    drug.setBarcode(dbarcode);	    

	    try {
	    	di.deleteDrug(drug);
	    	response.sendRedirect("medicine.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			PrintWriter out = response.getWriter();  
	 
	         out.println("<html><body>");
	         try
	         {
	        	 Connection connection=DatabaseConnectivity.getdata();
	     		 Statement statement=(Statement) connection.createStatement();
  
	             ResultSet rs = statement.executeQuery("select * from drug"); 
	             out.println("<table border=1 width=50% height=50%>");  
	             out.println("<tr><th>Drug Name<th>Barcode<th>Cost Price<th>Company Name</th><th>Quantity</th><tr>");  
	             while (rs.next()) 
	             {  
	            	 String drugName=rs.getString("NAME");
	            	 int barcode=rs.getInt("BARCODE");
	            	 System.out.println(barcode);
	            	 String costPrice=rs.getString("COST_PRICE");
	            	 String companyName=rs.getString("COMPANY_NAME");
	            	 int quantity=rs.getInt("QUANTITY");
	                   
	                 out.println("<tr><td>" + drugName + "</td><td>" + barcode + "</td><td>" + costPrice + "</td><td>" + companyName + "</td><td>" + quantity + "</td></tr>");   
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

