package com.kirti.foodplaza.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.kirti.foodplaza.dao.FoodDao;
import com.kirti.foodplaza.pojo.Food;

public class FoodDaoImpl implements FoodDao{

	HibernateTemplate hibernateTemplate;//hibernateTemplate this name should be same as in xml file
	
	//we used this for autowired using constructor injection
	public FoodDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public int save(Food food) {
		
		int id = (int)hibernateTemplate.save(food);
		return id;
	}

	@Override
	@Transactional
	public boolean delete(int foodId) {
		try
		{
			Food f = getById(foodId);
			hibernateTemplate.delete(f);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public Food update(Food food) {
		hibernateTemplate.update(food);
		return food;
		
		
	}

	@Override
	public List<Food> getFoodList() {
		List<Food> flist = hibernateTemplate.loadAll(Food.class);
		
		return flist;
	}

	@Override
	public Food getById(int foodId) {
	 Food f = hibernateTemplate.get(Food.class, foodId);
		return f;
	}

}
