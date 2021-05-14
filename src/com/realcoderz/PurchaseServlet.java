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
import pojoClass.PurchaseClass;
import user.PurchaseDAOImpl;

public class PurchaseServlet extends HttpServlet
{
	private static final long serialVersionUID= 1L;
	PurchaseDAOImpl di=new PurchaseDAOImpl();
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    PrintWriter pw=response.getWriter();
	    	
	    int barcode=Integer.parseInt(request.getParameter("barcode"));
		String user_name=request.getParameter("name");;
		String medicine_name=request.getParameter("med_name");;
		String company_name=request.getParameter("company_name");;
		int quantity=Integer.parseInt(request.getParameter("quantity"));;
		int price=Integer.parseInt(request.getParameter("price"));;
		int total_amount=Integer.parseInt(request.getParameter("amount"));;
			    	    
	    PurchaseClass purchase=new PurchaseClass();
	    purchase.setBarcode(barcode);
	    purchase.setUser_name(user_name);
	    purchase.setMedicine_name(medicine_name);
	    purchase.setCompany_name(company_name);
	    purchase.setQuantity(quantity);
	    purchase.setPrice(price);
	    purchase.setTotal_amount(total_amount);

	    try {
	    	di.insertPurchase(purchase);
	    	response.sendRedirect("welcome.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("barcode_not.html");
			e.printStackTrace();
		}
	}
}