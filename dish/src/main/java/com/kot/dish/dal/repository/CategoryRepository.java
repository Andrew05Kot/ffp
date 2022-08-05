package com.kot.dish.dal.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.kot.dish.dal.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long>,
		JpaSpecificationExecutor<CategoryEntity>,
		PagingAndSortingRepository<CategoryEntity, Long> {
}
