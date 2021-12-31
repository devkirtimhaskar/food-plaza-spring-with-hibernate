package com.kirti.foodplaza.dao;

import com.kirti.foodplaza.pojo.Order;

public interface OrderDao {

	Order placeOrder(String custEmailId, double totalPrice);
	
}
