package com.kirti.foodplaza.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.kirti.foodplaza.dao.LoginDao;
import com.kirti.foodplaza.pojo.Admin;
import com.kirti.foodplaza.pojo.Customer;

public class LoginDaoImpl implements LoginDao{

	HibernateTemplate hibernateTemplate;//hibernateTemplate this name should be same as in xml file
	
	
	public LoginDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public boolean isCustomer(String emailId, String password) {
	//	List<Customer> custList =(List<Customer>) hibernateTemplate.find("From Customer WHERE custEmail=:? AND custPassword:=?",emailId, password);//not worked
		String sqlQuery = "from Customer WHERE custEmail='"+emailId+"'and custPassword='"+password+"'";
		List<Customer> custList =(List<Customer>) hibernateTemplate.find(sqlQuery);
		return !custList.isEmpty();
	}


	@Override
	public boolean isAdmin(String emailId, String password) {
	//	List<Admin> adminList =(List<Admin>) hibernateTemplate.find("From Admin WHERE adminEmailId:=? AND adminPassword:=?",emailId, password);
	/*	if(adminList.isEmpty())
			return false;
		else
			return true;
			*/
		
		String sqlQuery = "from Admin WHERE adminEmailId='"+emailId+"'and adminPassword='"+password+"'";
		List<Admin> adminList =(List<Admin>) hibernateTemplate.find(sqlQuery);
		return !adminList.isEmpty();
	}

	
}
