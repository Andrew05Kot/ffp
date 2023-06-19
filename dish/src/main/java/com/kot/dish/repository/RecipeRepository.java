package com.kot.dish.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.dish.domain.RecipeEntity;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity, Long>,
		JpaSpecificationExecutor<RecipeEntity>,
		PagingAndSortingRepository<RecipeEntity, Long> {
}
