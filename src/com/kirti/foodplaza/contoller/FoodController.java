package com.kirti.foodplaza.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kirti.foodplaza.dao.FoodDao;
import com.kirti.foodplaza.pojo.Food;

@Controller
public class FoodController {

	//automatically fooddao bean is injected loosely coupled
	@Autowired
	FoodDao fdao ;
	
	@GetMapping(value = {"/", "/home"})//one handler method having multiple url pattern
	public String home(HttpSession session)
	{
		
		List<Food> flist = fdao.getFoodList(); 
	//	model.addAttribute("foodlist", flist);
		session.setAttribute("foodlist", flist);
		return "index";
	}
	
	@RequestMapping("/addfood")//postmapping not working why
	public String showFoodForm()
	{
		return "addfood";
	}
	
	@PostMapping("/savefood")
	public ModelAndView save(@ModelAttribute("food") Food food,@RequestParam("file") MultipartFile foodImage) throws IOException
	{
		ModelAndView mv = new ModelAndView();
		
		food.setFoodImage(foodImage.getBytes());
		
		int id = fdao.save(food);
		mv.addObject("msg","Food is added");
		mv.addObject("foodId",id);
		mv.setViewName("addfood");
		return mv;
	}
	
	@RequestMapping(value="/editfood")
	public ModelAndView edit(@RequestParam("foodId") int foodId)
	{
		ModelAndView mv = new ModelAndView();
		Food food = fdao.getById(foodId);
		
		mv.addObject("food",food);
		
		mv.addObject("action","update");
		
		mv.setViewName("addfood");
		return mv;
	}
	
	@PostMapping(value="/updatefood")
	public ModelAndView update(@ModelAttribute("food") Food food,@RequestParam("file") MultipartFile foodImage) throws IOException
	{
		ModelAndView mv = new ModelAndView();
		if(foodImage.getSize()!=0)
		{
			food.setFoodImage(foodImage.getBytes());
		}
		else
		{
			//if we dont wnt to update get old image from db
			Food f = fdao.getById(food.getFoodId());
			food.setFoodImage(f.getFoodImage());
		}
		Food f = fdao.update(food);
		
		if(f!=null)
		{
			mv.addObject("msg","food is updated");
			List<Food> flist = fdao.getFoodList();

			mv.addObject("foodlist",flist);
			mv.setViewName("foodlist");
		}
		else
		{
			mv.addObject("msg","food is not update");
			mv.addObject("food",food);
			mv.setViewName("addfood");
		}
		return mv;
	}
	
	@GetMapping("/foodlist")
	public ModelAndView list(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		List<Food> flist = fdao.getFoodList();
		session.setAttribute("foodlist",flist);
	//	mv.addObject("foodlist",flist);
		mv.setViewName("foodlist");
		return mv;
	}
	
	@RequestMapping("/deletefood")
	public ModelAndView deleteFood(@RequestParam("foodId") int foodId)
	{
		ModelAndView mv = new ModelAndView();
		boolean flag = fdao.delete(foodId);
		if(flag)
			mv.addObject("msg","Food is deleted");
		else
			mv.addObject("emsg","Food is not deleted");
		
		List<Food> flist = fdao.getFoodList();

		mv.addObject("foodlist",flist);
		mv.setViewName("foodlist");
		return mv;
	}
	
	@GetMapping(value="/foodimage",produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getFoodImage(@RequestParam("foodId") int foodId)
	{
		Food f = fdao.getById(foodId);
		if(f!=null)
		{
			byte fimage[] = f.getFoodImage();
			return fimage;
		}
		return null;
	}
}
