package user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import pojoClass.CompanyClass;
import pojoClass.DrugClass;

import dbconfig.DatabaseConnectivity;

public class DrugDAOImpl
{
	DatabaseConnectivity db_obj=new DatabaseConnectivity();
	int count;

	public int insertDrug(DrugClass drug) throws ClassNotFoundException,SQLException
	{
		try
		{
			
			String name=drug.getDrugName();
			int barcode=drug.getBarcode();
			String costPrice=drug.getCostPrice();
			String companyName=drug.getCompanyName();
			int quantity=drug.getQuantity();
			
			Connection connection=DatabaseConnectivity.getdata();
			Statement statement=connection.createStatement();
			
			//String insertData="insert into company values('"+name+"','"+address+"','"+number+"')";
			count=statement.executeUpdate("insert into drug(NAME,BARCODE,COST_PRICE,COMPANY_NAME,QUANTITY)values"
					+"('"+name+"','"+barcode+"','"+costPrice+"','"+companyName+"','"+quantity+"')");
			if(count==1)
			{
				System.out.println("Drug added successfully");
			}
			else
			{
				System.out.println("Try again");
			}

			
		}catch(Exception e)
		{
			throw e;
		}
		return count;
	}
	public int updateDrug(DrugClass drug) throws ClassNotFoundException 
	{ 
		try 
		{ 
			String dname=drug.getDrugName();
			int dbarcode=drug.getBarcode();
			String costPrice=drug.getCostPrice();
			String companyName=drug.getCompanyName(); 
			int quantity=drug.getQuantity();
			
			Connection connection=DatabaseConnectivity.getdata();
			Statement statement=connection.createStatement(); 
	        
			String updateData="update drug set NAME='"+dname+"',COST_PRICE="+costPrice+",COMPANY_NAME='"+companyName+
	        		"',QUANTITY="+quantity+" where BARCODE='"+dbarcode+"'";
			//int newQuantity=oldQuantity-current;
	        
	        statement.executeUpdate(updateData);
	        
	        System.out.println(updateData); 
	        System.out.println("Data Update Successfully"); 
	     } 
		catch(SQLException e) 
		{
			System.out.println(e); 
		} 
		int rowUpdateCount=0; 
		return rowUpdateCount; 
	}
	public int deleteDrug(DrugClass drug) throws ClassNotFoundException 
	{ 
		try 
		{ 
			int dbarcode=drug.getBarcode();
			
			Connection connection=DatabaseConnectivity.getdata();
			Statement statement=connection.createStatement(); 
	        
			String deleteData="delete from drug where BARCODE='"+dbarcode+"'";
	        
	        statement.executeUpdate(deleteData); 
	        System.out.println(deleteData); 
	        System.out.println("Data deleted Successfully"); 
	     } 
		catch(SQLException e) 
		{
			System.out.println(e); 
		} 
		int rowUpdateCount=0; 
		return rowUpdateCount; 
	}	
}

