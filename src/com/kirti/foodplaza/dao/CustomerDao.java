package com.kirti.foodplaza.dao;

import java.util.List;

import com.kirti.foodplaza.pojo.Customer;
import com.kirti.foodplaza.pojo.Food;

public interface CustomerDao {
	int save(Customer cust);
	boolean delete(int custId);
	Customer update(Customer cust);
	List<Customer> getCustomerList();
	Customer getById(int custId);
}
