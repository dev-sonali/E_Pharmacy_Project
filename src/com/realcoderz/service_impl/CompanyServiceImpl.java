package com.realcoderz.service_impl;

import java.sql.SQLException;

import com.realcoderz.service.CompanyService;

import daoInterface.CompanyDao;
import pojoClass.CompanyClass;
import user.CompanyDAOImpl;

public class CompanyServiceImpl implements CompanyService
{
	private CompanyDAOImpl companyDao=new CompanyDAOImpl();

	@Override
	public int insertCompany(CompanyClass company) throws ClassNotFoundException, SQLException 
	{
		int rowsUpdateCount=0;
		try
		{
			rowsUpdateCount=companyDao.insertCompany(company);
		}catch(ClassNotFoundException|SQLException e)
		{
			throw e;
		}
		// TODO Auto-generated method stub
		return rowsUpdateCount;
	}
}
