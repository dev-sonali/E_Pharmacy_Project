package user;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojoClass.DrugClass;
import pojoClass.PurchaseClass;
import dbconfig.DatabaseConnectivity;

public class PurchaseDAOImpl
{
	DatabaseConnectivity db_obj=new DatabaseConnectivity();
	int count;
	//private static Connection connection;
	//private static Statement statement;
	public int insertPurchase(PurchaseClass purchase) throws ClassNotFoundException,SQLException
	{
		try
		{
			int barcode=purchase.getBarcode();
			String upData="Select * from drug where BARCODE="+barcode;
			String user_name=purchase.getUser_name();
			String medicine_name=purchase.getMedicine_name();
			String company_name=purchase.getCompany_name();
			int quantity=purchase.getQuantity();
			int price=purchase.getPrice();
			int total_amount=purchase.getTotal_amount();
			
			String gettingQtyFromDb="Select QUANTITY from drug where BARCODE="+barcode;
			
			Connection connection=DatabaseConnectivity.getdata();
			Statement statement=connection.createStatement();
			
			
			ResultSet rs=statement.executeQuery(upData);
			
			if(!rs.next())
			{
				System.out.println("barcode doesn't exist");
			}

			int newQuantity=0;
			ResultSet availableQuantity=statement.executeQuery(gettingQtyFromDb);
			//int current=availableQuantity.getInt("QUANTITY");
			while(availableQuantity.next())
			{
				int current=availableQuantity.getInt("QUANTITY");
			newQuantity=current-quantity;
			System.out.println("newQuantity");
			
			}
			String updateQuantity="update drug set QUANTITY="+newQuantity+" where BARCODE="+barcode;
			statement.executeUpdate(updateQuantity);		
	
			
			
			//String insertData="insert into company values('"+name+"','"+address+"','"+number+"')";
			count=statement.executeUpdate("insert into purchase(BARCODE,USER_NAME,MEDICINE_NAME,COMPANY_NAME,QUANTITY,PRICE,"
					+ "TOTAL_AMOUNT)values"+"('"+barcode+"','"+user_name+"','"+medicine_name+"','"+company_name+"','"+quantity+"',"
							+ "'"+price+"','"+total_amount+"')");
			if(count==1)
			{
				System.out.println("Purchase added successfully");
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
}