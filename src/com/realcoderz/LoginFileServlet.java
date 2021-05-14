package com.realcoderz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFileServlet extends HttpServlet
{
	//private static final long serialVersionUID= 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException		
		{
	    PrintWriter pw=response.getWriter();
	    
	    String userName=request.getParameter("name");
	    String password=request.getParameter("password");
	    try
	    {
	    	fun(userName,password);
	    	response.sendRedirect("medicine.html");
	    }catch(LoginFailException e)
	    {
	    	pw.write("Login Failed");
	    }
	    
	    /*if(userName.equals("sonali")&&password.equals("sonali"))
	    { 
	    	pw.write("<h3>Welcome "+userName+", Your Login Successful");
	    	try {
		    	response.sendRedirect("medicine.html");
			} catch (LoginFailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else
	    { 
	    	//throw new LoginFailException("Login failed"); 
	    	pw.write("Login Failed");
	    }*/
	 }
		public void fun(String userName,String Password) throws LoginFailException
		{
			if(!userName.equals("sonali")||!Password.equals("sonali"))
			{
				throw new LoginFailException("Wrong user name or password."); 
			}
		}

}
