package com.kot.dish.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.dish.domain.DishEntity;
import com.kot.dish.repository.DishRepository;

@Service
public class DishDao {

	@Autowired
	private DishRepository dishRepository;

	public DishEntity create(DishEntity entity) {
		return this.dishRepository.save(entity);
	}

	public DishEntity update(DishEntity entity, Long id) {
		return this.dishRepository.save(entity);
	}

	public DishEntity findById(Long id) {
		return dishRepository.findById(id).orElse(null);
	}

	public Page<DishEntity> findAll() {
		return dishRepository.findAll(Specification.where(null), Pageable.unpaged());
	}

	public Page<DishEntity> findAll(Specification<DishEntity> filter, Pageable pageable) {
		return dishRepository.findAll(filter, pageable);
	}

	public List<DishEntity> findAll(Specification<DishEntity> specification) {
		return dishRepository.findAll(specification);
	}

	public Page<DishEntity> findAll(Pageable pageable) {
		Sort sort = pageable.getSort();
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

		return dishRepository.findAll(pageRequest);
	}
}
