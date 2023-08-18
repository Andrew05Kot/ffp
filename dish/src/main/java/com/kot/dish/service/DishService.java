package com.kot.dish.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.dish.dao.DishDao;
import com.kot.dish.domain.DishEntity;
import com.kot.dish.filtering.criteria_parser.FilteringCriteria;
import com.kot.dish.filtering.criteria_parser.FilteringCriteriaParser;
import com.kot.dish.filtering.models.dish.DishSpecificationsBuilder;

@Service
public class DishService {

	@Autowired
	private DishDao dishDao;

	@Autowired
	private FilteringCriteriaParser searchCriteriaParser;

	private final DishSpecificationsBuilder dishSpecificationsBuilder = new DishSpecificationsBuilder();

	public DishEntity create(DishEntity dish) {
		return dishDao.create(dish);
	}

	public DishEntity update(DishEntity dish, Long id) {
		return dishDao.update(dish, id);
	}

	public DishEntity findById(Long id) {
		return dishDao.findById(id);
	}

	public Page<DishEntity> findAll() {
		return dishDao.findAll();
	}

	public Page<DishEntity> findAll(String search, Pageable pageable) {
		Specification<DishEntity> specification = buildSpecification(search);
		return dishDao.findAll(specification, pageable);
	}

	public Page<DishEntity> findAll(Specification<DishEntity> filter, Pageable pageable) {
		return dishDao.findAll(filter, pageable);
	}

	public List<DishEntity> findAll(Specification<DishEntity> specification) {
		return dishDao.findAll(specification);
	}

	public Page<DishEntity> findAll(Pageable pageable) {
		return dishDao.findAll(pageable);
	}

	private Specification<DishEntity> buildSpecification(String filter) {
		Specification<DishEntity> filteringSpecification = null;
		if (filter != null) {
			List<FilteringCriteria> searchCriteria = searchCriteriaParser.parseSearchCriteria(filter,
					this.dishSpecificationsBuilder.getAllowedFilterableProperties());
			filteringSpecification = this.dishSpecificationsBuilder.buildSpecification(searchCriteria);
		}
		return filteringSpecification;
	}
}
