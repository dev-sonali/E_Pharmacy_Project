package user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojoClass.UserClass;

import dbconfig.DatabaseConnectivity;

public class UserDAOImpl
{
	DatabaseConnectivity db_obj=new DatabaseConnectivity();
	int count;
	//private static Connection connection;
	//private static Statement statement;
	public int insertUser(UserClass user) throws ClassNotFoundException,SQLException
	{
		try
		{
			
			int id=user.getUserId();
			String name=user.getUname();
			String address=user.getUaddress();
			String number=user.getUnumber();
			String email=user.getUmail();
			String password=user.getUpassword();
			
			Connection connection=DatabaseConnectivity.getdata();
			Statement statement=connection.createStatement();
			
			//String insertData="insert into company values('"+name+"','"+address+"','"+number+"')";
			count=statement.executeUpdate("insert into user(USER_ID,NAME,ADDRESS,NUMBER,EMAIL,PASSWORD)values"
					+"('"+id+"','"+name+"','"+address+"','"+number+"','"+email+"','"+password+"')");
			if(count==1)
			{
				System.out.println("User added successfully");
			}
			else
			{
				System.out.println("Try again");
			}
			
			//Object rowsUpdateCount = statement.executeUpdate(insertData);

			
		}catch(Exception e)
		{
			throw e;
		}
		return count;
	}
	public int updateUser(UserClass user) throws ClassNotFoundException 
	{ 
		try 
		{ 
			int id=user.getUserId();
			String name=user.getUname();
			String address=user.getUaddress();
			String number=user.getUnumber();
			String email=user.getUmail();
			
			
			Connection connection=DatabaseConnectivity.getdata();
			Statement statement=connection.createStatement(); 

			String updateData="update user set NAME='"+name+"',ADDRESS="+address+",NUMBER='"+number+
	        		"',EMAIL="+email+" where USER_ID='"+id+"'";

			
	        statement.executeUpdate(updateData); 
	       
	        System.out.println("Data Update Successfully"); 
	     } 
		catch(SQLException e) 
		{
			System.out.println(e); 
		} 
		int rowUpdateCount=0; 
		return rowUpdateCount; 
	}
	public ArrayList<UserClass> showUser() throws ClassNotFoundException, SQLException {
		ArrayList<UserClass> list=new ArrayList<UserClass>();

		try {
			Connection connection = db_obj.getdata();
			Statement statement = connection.createStatement();
			
	String updateData="select * from user";
	ResultSet rs=statement.executeQuery(updateData);
	while(rs.next())
	{
		UserClass userObj=new UserClass();
		
		userObj.setUserId(rs.getInt(1));
		userObj.setUnumber(rs.getString(2));
		userObj.setUaddress(rs.getString(3));
		userObj.setUnumber(rs.getString(4));
		userObj.setUmail(rs.getString(5));
		userObj.setUpassword(rs.getString(6));
		
		list.add(userObj);
	     }
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			db_obj.getdata();
		}
        return list;
	}
}

