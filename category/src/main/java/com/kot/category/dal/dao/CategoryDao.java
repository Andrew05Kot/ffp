package com.kot.category.dal.dao;

import com.kot.category.dal.model.CategoryEntity;
import com.kot.category.dal.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CategoryDao {

	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryEntity save(CategoryEntity entity, Long id) {
		return this.categoryRepository.save(entity);
	}

	public CategoryEntity findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	public Page<CategoryEntity> findAll() {
		return categoryRepository.findAll(Specification.where(null), Pageable.unpaged());
	}

	public Page<CategoryEntity> findAll(Specification specification) {
		return (Page<CategoryEntity>) categoryRepository.findAll(specification);
	}

	public Page<CategoryEntity> findAll(Specification<CategoryEntity> filter, Pageable pageable) {
		return findAll(filter, pageable);
	}
}
