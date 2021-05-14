package daoInterface;

import java.sql.SQLException;

import pojoClass.CompanyClass;

public interface CompanyDao 
{
	int insertCompany(CompanyClass company)throws ClassNotFoundException, SQLException;
	public void updateCompany(CompanyClass company)throws ClassNotFoundException,SQLException;
}
