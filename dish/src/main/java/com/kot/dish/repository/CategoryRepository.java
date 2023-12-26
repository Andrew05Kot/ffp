package com.kot.dish.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.dish.domain.CategoryEntity;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long>,
		JpaSpecificationExecutor<CategoryEntity>,
		PagingAndSortingRepository<CategoryEntity, Long> {

	CategoryEntity findByName(String name);
}
