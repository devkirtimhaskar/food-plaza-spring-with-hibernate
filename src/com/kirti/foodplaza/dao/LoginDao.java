package com.kirti.foodplaza.dao;

public interface LoginDao {
	boolean isCustomer(String emailId,String password);
//	boolean custChangePassword(String userName, String newPassword);
	boolean isAdmin(String emailId,String password);
//	boolean adminChangePassword(String userName,String newPassword);
	
}
