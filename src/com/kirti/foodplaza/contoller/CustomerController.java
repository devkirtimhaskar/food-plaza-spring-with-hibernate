package com.kirti.foodplaza.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kirti.foodplaza.dao.CustomerDao;
import com.kirti.foodplaza.pojo.Customer;
@Controller
public class CustomerController {

	@Autowired
	CustomerDao cdao ; 
		
	@GetMapping("/addcustomer")
	public String showCustomerForm()
	{
		return "addcustomer";
	}
	
	@PostMapping("/savecustomer")
	public ModelAndView save(@ModelAttribute("customer") Customer cust)
	{
		ModelAndView mv = new ModelAndView();
		int id = cdao.save(cust);
		mv.addObject("msg","Cust is added");
		mv.addObject("custId",id);
		mv.setViewName("addcustomer");
		return mv;
	}
	
	@GetMapping("/custlist")
	public ModelAndView list()
	{
		ModelAndView mv = new ModelAndView();
		List<Customer> custlist = cdao.getCustomerList();

		mv.addObject("custlist",custlist);
		mv.setViewName("custlist");
		return mv;
	}
	
	@RequestMapping("/deletecust")
	public ModelAndView deletecust(@RequestParam("custId")int custId)
	{
		ModelAndView mv = new ModelAndView();
		boolean flag = cdao.delete(custId);
		if(flag)
			mv.addObject("msg","Customer is deleted");
		else
			mv.addObject("emsg","Customer is not deleted");
		
		List<Customer> custlist = cdao.getCustomerList();

		mv.addObject("custlist",custlist);
		mv.setViewName("custlist");
		return mv;
	}
	
	@RequestMapping(value="/editcust")
	public ModelAndView edit(@RequestParam("custId") int custId)
	{
		ModelAndView mv = new ModelAndView();
		Customer cust = cdao.getById(custId);
		
		mv.addObject("cust",cust);
		
		mv.addObject("action","update");
		
		mv.setViewName("addcustomer");
		return mv;
	}

	@PostMapping(value="/updatecustomer")
	public ModelAndView update(@ModelAttribute("cust") Customer cust)
	{
		ModelAndView mv = new ModelAndView();
		Customer c = cdao.update(cust);
		
		if(c!=null)
		{
			mv.addObject("msg","Customer is updated");
			List<Customer> clist = cdao.getCustomerList();

			mv.addObject("custlist",clist);
			mv.setViewName("custlist");
		}
		else
		{
			mv.addObject("msg","Customer is not update");
			mv.addObject("cust",cust);
			mv.setViewName("addcustomer");
		}
		return mv;
	}
	
}
