package com.kot.bll;

import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.kot.dal.OrderDao;
import com.kot.dal.OrderEntity;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public Order save(Order model) {
		model.setCreationDate(ZonedDateTime.now());
		OrderEntity orderEntity = orderDao.save(OrderBLLMapper.INSTANCE.modelToEntity(model), model.getId());
		return OrderBLLMapper.INSTANCE.entityToModel(orderEntity);
	}

	public Order findById(Long id) {
		return OrderBLLMapper.INSTANCE.entityToModel(orderDao.findById(id));
	}

	public Page<Order> findAll() {
		return orderDao.findAll().map(OrderBLLMapper.INSTANCE::entityToModel);
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
