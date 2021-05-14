package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.realcoderz.LoginFileServlet;
import com.realcoderz.service_impl.CompanyServiceImpl;
import com.realcoderz.service_impl.DrugServiceImpl;
import com.realcoderz.service_impl.PurchaseServiceImpl;
import com.realcoderz.service_impl.UserServiceImpl;

import pojoClass.CompanyClass;
import pojoClass.DrugClass;
import pojoClass.PurchaseClass;
import pojoClass.UserClass;
import user.CompanyDAOImpl;
import user.DrugDAOImpl;
import user.PurchaseDAOImpl;
import user.UserDAOImpl;

@RunWith(JUnit4.class)
public class Junit 
{
	CompanyClass sub;
	UserClass user2;
	DrugClass drug;
	PurchaseClass purchase;
		
	CompanyServiceImpl company_serviceI;	
	CompanyDAOImpl companyDao;
	UserDAOImpl user;
	LoginFileServlet login;
	
	
	int flag;
	@Before
	public void init(){}
	
	@Test
	public void junit_test()
	{
		sub=new CompanyClass();
		sub.setCompanyName("abc");
		sub.setCompanyAddress("def");
		sub.setCompanyNumber("1234");
		assertEquals("abc",sub.getCompanyName());
		assertEquals("def",sub.getCompanyAddress());
		assertEquals("1234",sub.getCompanyNumber());
	}
	@Test
	public void drug_test() throws ClassNotFoundException, SQLException
	{
		
		drug=new DrugClass();	
		
		drug.setBarcode(1);
		drug.setCompanyName("xyz");
		drug.setCostPrice("75");
		drug.setDrugName("abc");
		drug.setPurchase_obj(purchase);
		drug.setQuantity(21);
		
		assertEquals(1,drug.getBarcode());
		assertEquals("xyz",drug.getDrugName());
		assertEquals("75",drug.getCostPrice());
		assertEquals("abc",drug.getCompanyName());
		assertEquals(21,drug.getQuantity());
	}
	
	@Test
	public void purchase_test()
	{
		purchase=new PurchaseClass();
		
		purchase.setBarcode(1);
		purchase.setCompany_name("abc");
		purchase.setDrugclass(drug);
		purchase.setMedicine_name("abc");
		purchase.setPrice(56);
		purchase.setQuantity(2);
		purchase.setTotal_amount(22);
		purchase.setUser_name("xyz");
		
		assertEquals(1,purchase.getBarcode());
		assertEquals("abc",purchase.getCompany_name());
		assertEquals(drug,purchase.getMedicine_name());
		assertEquals("abc",purchase.getPrice());
		assertEquals(56,purchase.getQuantity());
		assertEquals(2,purchase.getTotal_amount());
		assertEquals(22,purchase.getUser_name());
		assertEquals("xyz",purchase.getUser_name());
	}
	@Test
	public void companyDaoI_test() throws ClassNotFoundException, SQLException
	{
		
		company_serviceI=new CompanyServiceImpl();	
		int actual=company_serviceI.insertCompany(sub);
		flag=1;
		int expected=1;
		assertEquals(expected,actual);
    }
		@Test
	public void user_test2() throws ClassNotFoundException, SQLException
	{
		
		user2=new UserClass();	
		
		user2.setUaddress("xyz");
		user2.setUmail("abc");
		user2.setUname("dbc");
		user2.setUnumber("676");
		user2.setUpassword("gh");
		user2.setUserId(1);
		
		assertEquals("xyz",user2.getUaddress());
		assertEquals("abc",user2.getUmail());
		assertEquals("dbc",user2.getUname());
		assertEquals("676",user2.getUnumber());
		assertEquals("gh",user2.getUpassword());
		assertEquals(1,user2.getUserId());
	}
	@Test
	public void login_test()
	{
		
		login=new LoginFileServlet();		
		assertEquals(true,login);
	}
	@Test
	public void companyDao_test() throws ClassNotFoundException, SQLException
	{
		
		companyDao=new CompanyDAOImpl();	
		int actual=companyDao.insertCompany(sub);
		flag=1;
		int expected=1;
		assertEquals(expected,actual);
    }
		@Test
	public void user_test() throws ClassNotFoundException, SQLException
	{
		
		user=new UserDAOImpl();		
		assertEquals(true,user.showUser());
	}

}

