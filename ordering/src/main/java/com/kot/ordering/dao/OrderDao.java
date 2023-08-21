package com.kot.ordering.dao;

import java.util.List;
import com.kot.ordering.repository.OrderRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.ordering.domain.OrderEntity;

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
		return orderRepository.findAll(specification, pageable);
	}

	protected Specification<OrderEntity> addSpecifications() {
		return Specification.where(null);
	}

	protected Specification<OrderEntity> addAdditionalSpecificationsForGet() {
		return null;
	}
}
