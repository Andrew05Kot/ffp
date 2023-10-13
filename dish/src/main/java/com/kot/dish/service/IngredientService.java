package com.kot.dish.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.dish.dao.IngredientDao;
import com.kot.dish.domain.IngredientEntity;
import com.kot.dish.filtering.criteria_parser.FilteringCriteria;
import com.kot.dish.filtering.criteria_parser.FilteringCriteriaParser;
import com.kot.dish.filtering.models.ingredient.IngredientSpecificationsBuilder;

@Service
public class IngredientService {

	@Autowired
	private IngredientDao ingredientDao;

	@Autowired
	private FilteringCriteriaParser searchCriteriaParser;

	private final IngredientSpecificationsBuilder ingredientSpecificationsBuilder = new IngredientSpecificationsBuilder();

	public Page<IngredientEntity> findAll() {
		return ingredientDao.findAll();
	}

	public Page<IngredientEntity> findAll(String search, Pageable pageable) {
		Specification<IngredientEntity> specification = buildSpecification(search);
		return ingredientDao.findAll(specification, pageable);
	}

	public Page<IngredientEntity> findAll(Specification<IngredientEntity> filter, Pageable pageable) {
		return ingredientDao.findAll(filter, pageable);
	}

	public List<IngredientEntity> findAll(Specification<IngredientEntity> specification) {
		return ingredientDao.findAll(specification);
	}

	public Page<IngredientEntity> findAll(Pageable pageable) {
		return ingredientDao.findAll(pageable);
	}

	private Specification<IngredientEntity> buildSpecification(String filter) {
		Specification<IngredientEntity> filteringSpecification = null;
		if (filter != null) {
			List<FilteringCriteria> searchCriteria = searchCriteriaParser.parseSearchCriteria(filter,
					ingredientSpecificationsBuilder.getAllowedFilterableProperties());
			filteringSpecification = ingredientSpecificationsBuilder.buildSpecification(searchCriteria);
		}
		return filteringSpecification;
	}
}
