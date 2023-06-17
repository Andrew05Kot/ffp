package com.kot.dish.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.dish.domain.IngredientEntity;

@Repository
public interface IngredientRepository extends CrudRepository<IngredientEntity, Long>,
		JpaSpecificationExecutor<IngredientEntity>,
		PagingAndSortingRepository<IngredientEntity, Long> {

	IngredientEntity findByName(String name);
}
