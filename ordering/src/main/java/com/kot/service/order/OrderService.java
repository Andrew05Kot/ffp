package com.kot.service.order;

import java.time.ZonedDateTime;
import java.util.List;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.dao.OrderDao;
import com.kot.domain.OrderEntity;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public OrderEntity save(OrderEntity model) {
		model.setLastModifiedDate(ZonedDateTime.now());
		return orderDao.save(model, model.getId());
	}

	public OrderEntity findById(Long id) {
		return orderDao.findById(id);
	}

	public Page<OrderEntity> findAll() {
		return orderDao.findAll();
	}

	public Page<OrderEntity> findAll(Sort sort) {
		return orderDao.findAll();
	}

	public List<OrderEntity> findAll(Sort sort, BooleanExpression booleanExpression) {
		return orderDao.findAll(booleanExpression);
	}

	public List<OrderEntity> findAllList(Sort sort) {
		return orderDao.findAll(sort);
	}

	public List<OrderEntity> findAll(BooleanExpression booleanExpression) {
		return orderDao.findAll(booleanExpression);
	}

	public Page<OrderEntity> findAll(Specification<OrderEntity> specification) {
		return orderDao.findAll(specification);
	}

	public Page<OrderEntity> findAll(Pageable pageable) {
		return orderDao.findAll(pageable);
	}

	public Page<OrderEntity> findAll(Specification<OrderEntity> filter, Pageable pageable) {
		return orderDao.findAll(filter, pageable);
	}

}
