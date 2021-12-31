package com.kirti.foodplaza.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kirti.foodplaza.dao.LoginDao;
import com.kirti.foodplaza.pojo.Customer;

@Controller
public class LoginController {

	@Autowired 
	LoginDao ldao ;
	
	@GetMapping("/loginform")
	public String showLoginForm()
	{
		return "login";
	}
	
	@PostMapping("/dologin")
	public ModelAndView doLogin(@RequestParam("usertype") String usertype,
			@RequestParam("emailId") String emailId,
			@RequestParam("password") String password,
			HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(usertype.equalsIgnoreCase("admin"))
		{
			System.out.println("Admin login");
			boolean flag = ldao.isAdmin(emailId, password);
			if(flag)
			{
				session.setAttribute("admin", emailId);
				mv.addObject("Admin Login successfully..");
				mv.setViewName("index");
			}else
			{
				mv.addObject("Please Login Again");
				mv.setViewName("login");
			}
			
		}
		else if(usertype.equalsIgnoreCase("customer"))
		{
			System.out.println("Cust login");
			boolean flag = ldao.isCustomer(emailId, password);
			if(flag)
			{
				session.setAttribute("customer", emailId);
				mv.addObject("Customer Login successfully..");
				mv.setViewName("index");
			}else
			{
				mv.addObject("Please Login Again");
				mv.setViewName("login");
			}	
		}
		else
		{
			mv.addObject("msg","Select User Type ...");
			mv.setViewName("login");
		}
		return mv;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","Logout Successfull..");
//		mv.setViewName("");
//		return mv;
		
		return "redirect:home";
	}
}
