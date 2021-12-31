package com.kirti.foodplaza.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.kirti.foodplaza.dao.CartDao;
import com.kirti.foodplaza.pojo.Cart;

public class CartDaoImpl implements CartDao{

	HibernateTemplate hibernateTemplate;//hibernateTemplate this name should be same as in xml file
	
	
	public CartDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public boolean addToCart(Cart cart) {
		int i = (int) hibernateTemplate.save(cart);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public List<Cart> showCart(String custEmailId) {
		String sqlQuery="From Cart where cartCustEmailId='"+custEmailId+"'";
		
		List<Cart> cartList = (List<Cart>) hibernateTemplate.find(sqlQuery);
		return cartList;
	}

	@Override
	public List<Cart> showAllCart(Cart cart) {
		return hibernateTemplate.loadAll(Cart.class);		
	}

	@Override
	public boolean deleteFromCart(int cartId) {
	
		Cart cart = hibernateTemplate.get(Cart.class, cartId);
		
		if(cart!=null)
		{
			hibernateTemplate.delete(cart);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean updateCartQty(int cartId, int cartQty) {

		Cart cart = hibernateTemplate.get(Cart.class, cartId);
		cart.setCartFoodQuantity(cartQty);
		hibernateTemplate.update(cart);
		
		return true;
	}

}
