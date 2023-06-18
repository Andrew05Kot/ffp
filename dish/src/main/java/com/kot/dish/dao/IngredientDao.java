package com.kot.dish.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.dish.domain.IngredientEntity;
import com.kot.dish.repository.IngredientRepository;

@Service
public class IngredientDao {

	@Autowired
	private IngredientRepository ingredientRepository;

	public Page<IngredientEntity> findAll() {
		return ingredientRepository.findAll(Specification.where(null), Pageable.unpaged());
	}

	public Page<IngredientEntity> findAll(Specification<IngredientEntity> specification) {
		return (Page<IngredientEntity>) ingredientRepository.findAll(specification);
	}

	public Page<IngredientEntity> findAll(Specification<IngredientEntity> filter, Pageable pageable) {
		return findAll(filter, pageable);
	}

	public Page<IngredientEntity> findAll(Pageable pageable) {
		Specification<IngredientEntity> specification = addSpecifications().and(addAdditionalSpecificationsForGet());

		Sort sort = pageable.getSort();
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

		return ingredientRepository.findAll(specification, pageRequest);
	}

	protected Specification<IngredientEntity> addSpecifications() {
		return Specification.where(null);
	}

	protected Specification<IngredientEntity> addAdditionalSpecificationsForGet() {
		return null;
	}
}
