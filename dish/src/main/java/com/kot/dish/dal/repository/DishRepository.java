package com.kot.dish.dal.repository;

import com.kot.dish.dal.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends CrudRepository<DishEntity, Long>,
										JpaSpecificationExecutor<DishEntity>,
										PagingAndSortingRepository<DishEntity, Long> {
}
