package com.kirti.foodplaza.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.kirti.foodplaza.dao.CustomerDao;
import com.kirti.foodplaza.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {

	HibernateTemplate hibernateTemplate;//hibernateTemplate this name should be same as in xml file
	Customer cust = new Customer(); 

	public CustomerDaoImpl(HibernateTemplate hibernateTemplate) {
	super();
	this.hibernateTemplate = hibernateTemplate;
}

	@Override
	@Transactional
	public int save(Customer cust) {
		int id = (int)hibernateTemplate.save(cust);
		return id;
	}

	@Override
	@Transactional
	public boolean delete(int custId) {
	try {
		Customer cust = getById(custId);
		hibernateTemplate.delete(cust);
	 	return true;
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
		return false;
	}

	@Override
	@Transactional
	public Customer update(Customer cust) {
		hibernateTemplate.update(cust);
		return cust;
	}

	@Override
	public List<Customer> getCustomerList() {
		List<Customer> custlist = hibernateTemplate.loadAll(Customer.class);
		return custlist;	
	}

	@Override
	public Customer getById(int custId) {
		Customer c=hibernateTemplate.get(Customer.class,custId);
		return c;
	}

}
