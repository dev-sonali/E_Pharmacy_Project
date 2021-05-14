package com.realcoderz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojoClass.UserClass;
import user.UserDAOImpl;


public class UserLoginServlet extends HttpServlet
{
	//private static final long serialVersionUID= 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    PrintWriter pw=response.getWriter();
	    	    
	    Integer userId=Integer.parseInt(request.getParameter("id"));
	    String password=request.getParameter("password");
	    
	    UserDAOImpl userDao=new UserDAOImpl();
	    
	    try
	    {
	    	int count=0;
	    	ArrayList<UserClass> list = userDao.showUser();
	    	for(UserClass userObj: list)
	    	{
	    		if(userId.equals(userObj.getUserId()) && password.equals(userObj.getUpassword()))
	    		{
	    			pw.write("<h3>Welcome "+userId+", Your Login Successful");
	    		    response.sendRedirect("purchaseFile.html");
	    		    count++;
	       		}
	    	}
	    	if(count==0)
	    	{
	    		pw.write("Login Failed");
	    	}	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }	    
	}
}
