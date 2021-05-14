package com.realcoderz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconfig.DatabaseConnectivity;
import pojoClass.UserClass;
import user.UserDAOImpl;


public class UserServlet extends HttpServlet
{
	private static final long serialVersionUID= 1L;
	UserDAOImpl di=new UserDAOImpl();
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    PrintWriter pw=response.getWriter();
	    	    
	    int userId=Integer.parseInt(request.getParameter("user_id"));
	    String uname=request.getParameter("name");
	    String uaddress=request.getParameter("address");
	    String unumber=request.getParameter("number");
	    String umail=request.getParameter("email");
	    String upassword=request.getParameter("pwd");
	    	    	    
	    UserClass user=new UserClass();
	    user.setUserId(userId);
	    user.setUname(uname);
	    user.setUaddress(uaddress);
	    user.setUnumber(unumber);
	    user.setUmail(umail);
	    user.setUpassword(upassword);
	    
	    try {
	    	di.insertUser(user);
	    	response.sendRedirect("userRegister.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		    PrintWriter pw=response.getWriter();
		    	    
		    int userId=Integer.parseInt(request.getParameter("user_id"));
		    String uname=request.getParameter("name");
		    String uaddress=request.getParameter("address");
		    String unumber=request.getParameter("number");
		    String umail=request.getParameter("email");
		   	    	    
		    UserClass user=new UserClass();
		    user.setUserId(userId);
		    user.setUname(uname);
		    user.setUaddress(uaddress);
		    user.setUnumber(unumber);
		    user.setUmail(umail);
		  		    
		    try {
		    	di.updateUser(user);
		    	response.sendRedirect("welcome.html");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}


