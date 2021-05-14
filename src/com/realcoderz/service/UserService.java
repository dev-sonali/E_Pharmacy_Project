package com.realcoderz.service;

import java.sql.SQLException;

import pojoClass.UserClass;

public interface UserService 
{
	int insertUser(UserClass user)throws ClassNotFoundException, SQLException;
	//public void readCompany() throws ClassNotFoundException, SQLException;
}
