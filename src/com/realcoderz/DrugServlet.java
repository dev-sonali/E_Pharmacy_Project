package com.realcoderz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconfig.DatabaseConnectivity;
import pojoClass.DrugClass;
import user.DrugDAOImpl;

public class DrugServlet extends HttpServlet
{
	private static final long serialVersionUID= 1L;
	DrugDAOImpl di=new DrugDAOImpl();
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    PrintWriter pw=response.getWriter();
	    	    
	    String dname=request.getParameter("name");
	    int dbarcode=Integer.parseInt(request.getParameter("barcode"));
	    String costPrice=request.getParameter("costPrice");
	    String companyName=request.getParameter("companyName");
	    int dquantity=Integer.parseInt(request.getParameter("quantity"));
	    	    
	    DrugClass drug=new DrugClass();
	    drug.setDrugName(dname);
	    drug.setBarcode(dbarcode);
	    drug.setCostPrice(costPrice);
	    drug.setCompanyName(companyName);
	    drug.setQuantity(dquantity);
	    

	    try {
	    	di.insertDrug(drug);
	    	response.sendRedirect("medicine.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		    PrintWriter pw=response.getWriter();
		    	    
		    String dname=request.getParameter("name");
		    int dbarcode=Integer.parseInt(request.getParameter("barcode"));
		    String costPrice=request.getParameter("costPrice");
		    String companyName=request.getParameter("companyName");
		    int dquantity=Integer.parseInt(request.getParameter("quantity"));
		    	    
		    DrugClass drug=new DrugClass();
		    drug.setDrugName(dname);
		    drug.setBarcode(dbarcode);
		    drug.setCostPrice(costPrice);
		    drug.setCompanyName(companyName);
		    drug.setQuantity(dquantity);
		    

		    try {
		    	di.updateDrug(drug);
		    	response.sendRedirect("medicine.html");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


}

