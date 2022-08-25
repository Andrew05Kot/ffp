package com.kot.bll.order;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.kot.dal.OrderDao;
import com.kot.dal.OrderEntity;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public Order save(Order model) {
		model.setLastModifiedDate(ZonedDateTime.now());
		OrderEntity orderEntity = orderDao.save(OrderBLLMapper.INSTANCE.modelToEntity(model), model.getId());
		return OrderBLLMapper.INSTANCE.entityToModel(orderEntity);
	}

	public Order findById(Long id) {
		return OrderBLLMapper.INSTANCE.entityToModel(orderDao.findById(id));
	}

	public Page<Order> findAll() {
		return orderDao.findAll().map(OrderBLLMapper.INSTANCE::entityToModel);
	}

	public Page<Order> findAll(Sort sort) {
		return orderDao.findAll().map(OrderBLLMapper.INSTANCE::entityToModel);
	}

	public List<Order> findAll(Sort sort, BooleanExpression booleanExpression) {
		return orderDao.findAll(booleanExpression).stream().map(OrderBLLMapper.INSTANCE::entityToModel).toList();
	}
		public List<Order> findAllList(Sort sort) {
		return orderDao.findAll(sort).stream().map(OrderBLLMapper.INSTANCE::entityToModel).collect(Collectors.toList());
	}

	public List<Order> findAll(BooleanExpression booleanExpression) {
		return orderDao.findAll(booleanExpression).stream().map(OrderBLLMapper.INSTANCE::entityToModel).collect(Collectors.toList());
	}

	public Page<Order> findAll(Specification specification) {
		return orderDao.findAll(specification).map(OrderBLLMapper.INSTANCE::entityToModel);
	}

	public Page<Order> findAll(Pageable pageable) {
		return orderDao.findAll(pageable).map(OrderBLLMapper.INSTANCE::entityToModel);
	}

	public Page<Order> findAll(Specification<OrderEntity> filter, Pageable pageable) {
		return orderDao.findAll(filter, pageable).map(OrderBLLMapper.INSTANCE::entityToModel);
	}

}
