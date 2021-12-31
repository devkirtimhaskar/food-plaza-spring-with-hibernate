package com.kirti.foodplaza.dao.impl;

import java.time.LocalDateTime;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.kirti.foodplaza.dao.OrderDao;
import com.kirti.foodplaza.pojo.Order;

public class OrderDaoImpl implements OrderDao {

	HibernateTemplate hibernateTemplate;

	//Setter Injection for DI 
	//In other dao's we used constructor injection
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public Order placeOrder(String custEmailId, double totalPrice) {

		/*
		 * Order order = new Order(); order.setCustEmailId(custEmailId);
		 * order.setTotalAmount(totalPrice);
		 * 
		 */
		LocalDateTime orderDate = LocalDateTime.now();
		Order order = new Order(custEmailId, totalPrice,orderDate);

		int id = (int) hibernateTemplate.save(order);
		order = hibernateTemplate.get(Order.class, id);
		
		return order;
	}

}
