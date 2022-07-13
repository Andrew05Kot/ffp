package com.kot.dish.repository;

import com.kot.dish.model.DishEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends CrudRepository<DishEntity, Long>,
										JpaSpecificationExecutor<DishEntity>,
										PagingAndSortingRepository<DishEntity, Long> {
}
