package daoInterface;

import java.sql.SQLException;

import pojoClass.PurchaseClass;
 
public interface PurchaseDao 
{
	int insertPurchase(PurchaseClass purchase) throws ClassNotFoundException,SQLException;
	//public void updateCompany(DrugClass drug)throws ClassNotFoundException,SQLException;
	//int deleteDrug(DrugClass drug)throws ClassNotFoundException, SQLException;
	//ArrayList<Bus> showBus() throws ClassNotFoundException, SQLException;

}
