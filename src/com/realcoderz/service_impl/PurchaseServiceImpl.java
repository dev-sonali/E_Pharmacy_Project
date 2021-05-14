package com.realcoderz.service_impl;

import java.sql.SQLException;

import com.realcoderz.service.CompanyService;
import com.realcoderz.service.PurchaseService;

import daoInterface.CompanyDao;
import pojoClass.CompanyClass;
import pojoClass.PurchaseClass;
import user.CompanyDAOImpl;
import user.PurchaseDAOImpl;

public class PurchaseServiceImpl implements PurchaseService
{
	private PurchaseDAOImpl purchaseDao=new PurchaseDAOImpl();

	@Override
	public int insertPurchase(PurchaseClass purchase) throws ClassNotFoundException, SQLException 
	{
		int rowsUpdateCount=0;
		try
		{
			rowsUpdateCount=purchaseDao.insertPurchase(purchase);
		}catch(ClassNotFoundException|SQLException e)
     	{
			throw e;
		}
		// TODO Auto-generated method stub
		return rowsUpdateCount;
	}
}