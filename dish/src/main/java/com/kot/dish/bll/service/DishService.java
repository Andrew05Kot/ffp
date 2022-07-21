package com.kot.dish.bll.service;

import com.kot.dish.bll.mapper.DishBLLMapper;
import com.kot.dish.bll.model.Dish;
import com.kot.dish.dal.dao.DishDao;
import com.kot.dish.dal.entity.DishEntity;
import com.kot.dish.intercomm.category.CategoryClient;
import com.kot.dish.intercomm.category.CategoryResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DishService {

	@Autowired
	private DishDao dishDao;

	@Autowired
	private CategoryClient categoryClient;

	public Dish save(Dish dish) {
//		if (dish.getCategoryId() == null) {
//
//		}
//		CategoryResponseModel categoryResponseModel = categoryClient.getCategoryById(dish.getCategoryId());
//		if (categoryResponseModel == null) {
//			throw new
//		}
		DishEntity dishEntity = dishDao.save(DishBLLMapper.INSTANCE.modelToEntity(dish), dish.getId());
		return DishBLLMapper.INSTANCE.entityToModel(dishEntity);
	}

	public Dish findById(Long id) {
		return DishBLLMapper.INSTANCE.entityToModel(dishDao.findById(id));
	}

	public Page<Dish> findAll() {
		return dishDao.findAll().map(DishBLLMapper.INSTANCE::entityToModel);
	}

	public Page<Dish> findAll(Specification specification) {
		return dishDao.findAll(specification).map(DishBLLMapper.INSTANCE::entityToModel);
	}

	public Page<Dish> findAll(Specification<DishEntity> filter, Pageable pageable) {
		return dishDao.findAll(filter, pageable).map(DishBLLMapper.INSTANCE::entityToModel);
	}
}
