package daoInterface;

import java.sql.SQLException;

import pojoClass.DrugClass;
 
public interface DrugDao 
{
	int insertDrug(DrugClass drug) throws ClassNotFoundException,SQLException;
	public void updateCompany(DrugClass drug)throws ClassNotFoundException,SQLException;
	int deleteDrug(DrugClass drug)throws ClassNotFoundException, SQLException;
	//ArrayList<Bus> showBus() throws ClassNotFoundException, SQLException;

}
