package com.kot.dao;

import java.util.List;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.domain.OrderEntity;
import com.kot.repository.OrderRepository;

@Service
public class OrderDao {

	@Autowired
	private OrderRepository orderRepository;

	public OrderEntity save(OrderEntity entity, Long id) {
		return this.orderRepository.save(entity);
	}

	public OrderEntity findById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	public Page<OrderEntity> findAll() {
		return orderRepository.findAll(Specification.where(null), Pageable.unpaged());
	}

	public Page<OrderEntity> findAll(Specification<OrderEntity> specification) {
		return (Page<OrderEntity>) orderRepository.findAll(specification);
	}

	public List<OrderEntity> findAll(BooleanExpression booleanExpression) {
		return (List<OrderEntity>) orderRepository.findAll(booleanExpression);
	}

	public List<OrderEntity> findAll(Sort sort) {
		return (List<OrderEntity>) orderRepository.findAll(sort);
	}

	public Page<OrderEntity> findAll(Specification<OrderEntity> filter, Pageable pageable) {
		return findAll(filter, pageable);
	}

	public Page<OrderEntity> findAll(Pageable pageable) {

		Specification<OrderEntity> specification = addSpecifications().and(addAdditionalSpecificationsForGet());

		Sort sort = pageable.getSort();
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

		Page<OrderEntity> page = orderRepository.findAll(specification, pageRequest);

		return page;
	}

	protected Specification<OrderEntity> addSpecifications() {
		return Specification.where(null);
	}

	protected Specification<OrderEntity> addAdditionalSpecificationsForGet() {
		return null;
	}
}
