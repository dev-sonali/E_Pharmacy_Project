package daoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

import pojoClass.UserClass;

public interface UserDao 
{
	int insertUser(UserClass user)throws ClassNotFoundException, SQLException;
	public void updateUser(UserClass user)throws ClassNotFoundException,SQLException;
	ArrayList<UserClass> showUser() throws ClassNotFoundException, SQLException;

}
