package user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojoClass.CompanyClass;

import dbconfig.DatabaseConnectivity;

public class CompanyDAOImpl 
{
	DatabaseConnectivity db_obj=new DatabaseConnectivity();
	int count;
	//private static Connection connection;
	//private static Statement statement;
	public int insertCompany(CompanyClass company) throws ClassNotFoundException,SQLException
	{
		try
		{
		String name=company.getCompanyName();
		String address=company.getCompanyAddress();
		String number=company.getCompanyNumber();
		
		Connection connection=DatabaseConnectivity.getdata();
		Statement statement=connection.createStatement();
		
		//String insertData="insert into company values('"+name+"','"+address+"','"+number+"')";
		count=statement.executeUpdate("insert into company(Name,Address,Phone)values"
				+"('"+name+"','"+address+"','"+number+"')");
		if(count==1)
		{
			System.out.println("Company Register successfully");
		}
		else
		{
			System.out.println("Try again");
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return count;
	}
}
