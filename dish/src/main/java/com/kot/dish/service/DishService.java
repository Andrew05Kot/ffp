package com.kot.dish.service;

import com.kot.dish.dao.DishDao;
import com.kot.dish.model.DishEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DishService {

	@Autowired
	private DishDao dishDao;

	public DishEntity save(DishEntity dishEntity) {
		return dishDao.save(dishEntity, dishEntity.getId());
	}

	public DishEntity findById(Long id) {
		return dishDao.findById(id);
	}

	public Page<DishEntity> findAll() {
		return dishDao.findAll();
	}

	public Page<DishEntity> findAll(Specification specification) {
		return dishDao.findAll(specification);
	}

	public Page<DishEntity> findAll(Specification<DishEntity> filter, Pageable pageable) {
		return dishDao.findAll(filter, pageable);
	}

	public Page<DishEntity> findAll(Pageable pageable) {
		return findAll(pageable);
	}

}
