package com.kirti.foodplaza.dao;

import java.util.List;

import com.kirti.foodplaza.pojo.Food;

public interface FoodDao {
	int save(Food food);
	boolean delete(int foodId);
	Food update(Food food);
	List<Food> getFoodList();
	Food getById(int foodId);
}
