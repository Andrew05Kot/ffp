package com.kot.category.bll.service;

import com.kot.category.bll.mapper.CategoryBLLMapper;
import com.kot.category.bll.model.Category;
import com.kot.category.dal.dao.CategoryDao;
import com.kot.category.dal.model.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao dao;

	public Category save(Category category) {
		CategoryEntity categoryEntity = dao.save(CategoryBLLMapper.INSTANCE.modelToEntity(category), category.getId());
		return CategoryBLLMapper.INSTANCE.entityToModel(categoryEntity);
	}

	public Category findById(Long id) {
		return CategoryBLLMapper.INSTANCE.entityToModel(dao.findById(id));
	}

	public Page<Category> findAll() {
		return dao.findAll().map(CategoryBLLMapper.INSTANCE::entityToModel);
	}

	public Page<Category> findAll(Specification specification) {
		return dao.findAll(specification).map(CategoryBLLMapper.INSTANCE::entityToModel);
	}

	public Page<Category> findAll(Specification<CategoryEntity> filter, Pageable pageable) {
		return dao.findAll(filter, pageable).map(CategoryBLLMapper.INSTANCE::entityToModel);
	}
}
