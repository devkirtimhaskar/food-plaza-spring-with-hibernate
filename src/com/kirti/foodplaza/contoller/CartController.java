package com.kirti.foodplaza.contoller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kirti.foodplaza.dao.CartDao;
import com.kirti.foodplaza.dao.FoodDao;
import com.kirti.foodplaza.pojo.Cart;
import com.kirti.foodplaza.pojo.Food;

@Controller
public class CartController {

	Cart cart ;
	
	@Autowired
	CartDao cartDao ; 
	
	@Autowired 
	FoodDao fdao ;
	
	String cartCustEmailId;
	
	@RequestMapping(value="/addtocart", method = RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam int foodId,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		cartCustEmailId = (String)session.getAttribute("customer");
		if(cartCustEmailId!=null)
		{
			cart = new Cart();
			cart.setFoodId(foodId);
			cart.setCartFoodQuantity(1);
			cart.setCartCustEmailId(cartCustEmailId);
			
			//set FoodDetails 
			Food food = fdao.getById(foodId);
			cart.setFoodName(food.getFoodName());
			cart.setFoodPrice(food.getFoodPrice());
			
			boolean flag  = cartDao.addToCart(cart);
			
			if(flag)
			{
				mv.addObject("msg", "Food is added into cart and FoodId is : "+ foodId);
			}
			else
			{
				mv.addObject("msg", "Food is not added into cart");
			}
			mv.setViewName("index");
		}
		else {
			mv.addObject("msg","please do login");
			mv.setViewName("login");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/showmycart" ,method = RequestMethod.GET)
	public ModelAndView showMyCart(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		cartCustEmailId = (String)session.getAttribute("customer");
		
		if(cartCustEmailId!=null)
		{
			List<Cart> cartlist = cartDao.showCart(cartCustEmailId);
			session.setAttribute("cartlist", cartlist);
			
			mv.setViewName("cartlist");
			return mv;
		}
		mv.setViewName("index");

		return mv;
	}
	
	@RequestMapping(value = "updateCartQty" , method = RequestMethod.POST)
	@ResponseBody //it is used when we want to send msg to the view  
	public String updateCart(@RequestParam("cartId") int cartId, @RequestParam("cartQty") int cartQty)
	{
		boolean flag = cartDao.updateCartQty(cartId,cartQty);
		
		if(flag)
		{
			return "Cart Quantity is Updated";
		}
		else
		{
			return "Cart Quantity is not Updated";
		}
		
	}
}
