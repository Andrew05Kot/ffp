package com.kot.dish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.dish.dao.CategoryDao;
import com.kot.dish.domain.CategoryEntity;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao dao;

	public CategoryEntity save(CategoryEntity category) {
		return dao.save(category, category.getId());
	}

	public CategoryEntity findById(Long id) {
		return dao.findById(id);
	}

	public Page<CategoryEntity> findAll() {
		return dao.findAll();
	}

	public Page<CategoryEntity> findAll(Specification<CategoryEntity> specification) {
		return dao.findAll(specification);
	}

	public Page<CategoryEntity> findAll(Specification<CategoryEntity> filter, Pageable pageable) {
		return dao.findAll(filter, pageable);
	}
}
