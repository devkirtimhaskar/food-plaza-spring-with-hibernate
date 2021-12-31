package com.kirti.foodplaza.dao;

import java.util.List;

import com.kirti.foodplaza.pojo.Cart;

public interface CartDao {

	boolean addToCart(Cart cart);
	
	//customer view
	List<Cart> showCart(String custEmailId);
	
	//admin view
	List<Cart> showAllCart(Cart cart);
	
	boolean deleteFromCart(int cartId);

	boolean updateCartQty(int cartId, int cartQty);
}
