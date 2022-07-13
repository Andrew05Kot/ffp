package com.kot.category.dal.repository;

import com.kot.category.dal.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long>,
		JpaSpecificationExecutor<CategoryEntity>,
		PagingAndSortingRepository<CategoryEntity, Long> {
}
