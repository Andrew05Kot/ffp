package com.kot.dish.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.dish.domain.CategoryEntity;
import com.kot.dish.repository.CategoryRepository;

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

	public List<CategoryEntity> findAll(Specification<CategoryEntity> specification) {
		return categoryRepository.findAll(specification);
	}

	public Page<CategoryEntity> findAll(Specification<CategoryEntity> filter, Pageable pageable) {
		return findAll(filter, pageable);
	}
}
