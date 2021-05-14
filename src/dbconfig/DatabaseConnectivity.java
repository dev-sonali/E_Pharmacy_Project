package dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectivity {
	
	public static Connection connection;
	public static Statement statement;
	
	public static Connection getdata(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","sonali@1234");
			statement = connection.createStatement();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	public static void fun() throws SQLException
	{
		if(connection!=null)
		{
			connection.close();
		}
	}
}

