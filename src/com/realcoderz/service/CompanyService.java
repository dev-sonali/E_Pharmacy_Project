package com.realcoderz.service;

import java.sql.SQLException;

import pojoClass.CompanyClass;

public interface CompanyService 
{
	int insertCompany(CompanyClass company)throws ClassNotFoundException, SQLException;
	
}
