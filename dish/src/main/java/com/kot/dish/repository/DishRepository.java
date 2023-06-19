package com.kot.dish.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.dish.domain.DishEntity;

@Repository
public interface DishRepository extends CrudRepository<DishEntity, Long>,
		JpaSpecificationExecutor<DishEntity>,
		PagingAndSortingRepository<DishEntity, Long> {
}
