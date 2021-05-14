package com.realcoderz.service;

import java.sql.SQLException;

import pojoClass.PurchaseClass;

public interface PurchaseService 
{
	int insertPurchase(PurchaseClass purchase)throws ClassNotFoundException, SQLException;
	//public void readCompany() throws ClassNotFoundException, SQLException;
}
