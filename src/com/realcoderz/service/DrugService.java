package com.realcoderz.service;

import java.sql.SQLException;

import pojoClass.DrugClass;

public interface DrugService 
{
	int insertDrug(DrugClass drug)throws ClassNotFoundException, SQLException;
	//public void readCompany() throws ClassNotFoundException, SQLException;
}
