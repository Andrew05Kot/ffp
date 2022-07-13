package com.kot.dish.dal.dao;

import com.kot.dish.dal.entity.DishEntity;
import com.kot.dish.dal.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DishDao {

	@Autowired
	private DishRepository dishRepository;

	public DishEntity save(DishEntity entity, Long id) {
		return this.dishRepository.save(entity);
	}

	public DishEntity findById(Long id) {
		return dishRepository.findById(id).orElse(null);
	}

	public Page<DishEntity> findAll() {
		return dishRepository.findAll(Specification.where(null), Pageable.unpaged());
	}

	public Page<DishEntity> findAll(Specification specification) {
		return (Page<DishEntity>) dishRepository.findAll(specification);
	}

	public Page<DishEntity> findAll(Specification<DishEntity> filter, Pageable pageable) {
		return findAll(filter, pageable);
	}

	public Page<DishEntity> findAll(Pageable pageable) {

		Specification<DishEntity> specification = addSpecifications().and(addAdditionalSpecificationsForGet());

		Sort sort = pageable.getSort();
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

		Page<DishEntity> page = dishRepository.findAll(specification, pageRequest);

		return page;
	}

	protected Specification<DishEntity> addSpecifications() {
		return Specification.where(null);
	}

	protected Specification<DishEntity> addAdditionalSpecificationsForGet() {
		return null;
	}
}
