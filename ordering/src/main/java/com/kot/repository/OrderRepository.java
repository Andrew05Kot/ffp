package com.kot.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.domain.OrderEntity;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long>,
		JpaSpecificationExecutor<OrderEntity>,
		PagingAndSortingRepository<OrderEntity, Long>,
		QuerydslPredicateExecutor<OrderEntity> {
}
