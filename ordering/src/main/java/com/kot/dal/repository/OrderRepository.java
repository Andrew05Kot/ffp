package com.kot.dal.repository;

import com.kot.dal.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long>,
		JpaSpecificationExecutor<OrderEntity>,
		PagingAndSortingRepository<OrderEntity, Long>,
		QuerydslPredicateExecutor<OrderEntity> {
}
