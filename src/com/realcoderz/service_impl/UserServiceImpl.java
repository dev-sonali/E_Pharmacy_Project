package com.realcoderz.service_impl;

import java.sql.SQLException;

import com.realcoderz.service.UserService;

import pojoClass.UserClass;
import user.UserDAOImpl;

public class UserServiceImpl implements UserService
{
	private UserDAOImpl userDao=new UserDAOImpl();

	@Override
	public int insertUser(UserClass user) throws ClassNotFoundException, SQLException 
	{
		int rowsUpdateCount=0;
		try
		{
			rowsUpdateCount=userDao.insertUser(user);
		}catch(ClassNotFoundException|SQLException e)
		{
			throw e;
		}
		// TODO Auto-generated method stub
		return rowsUpdateCount;
	}
}