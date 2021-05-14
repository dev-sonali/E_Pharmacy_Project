package com.realcoderz.service_impl;

import java.sql.SQLException;

import com.realcoderz.service.CompanyService;
import com.realcoderz.service.DrugService;

import daoInterface.CompanyDao;
import pojoClass.DrugClass;
import user.DrugDAOImpl;

public class DrugServiceImpl implements DrugService
{
	private DrugDAOImpl drugDao=new DrugDAOImpl();

	@Override
	public int insertDrug(DrugClass drug) throws ClassNotFoundException, SQLException 
	{
		int rowsUpdateCount=0;
		try
		{
			rowsUpdateCount=drugDao.insertDrug(drug);
		}catch(ClassNotFoundException|SQLException e)
		{
			throw e;
		}
		// TODO Auto-generated method stub
		return rowsUpdateCount;
	}
}