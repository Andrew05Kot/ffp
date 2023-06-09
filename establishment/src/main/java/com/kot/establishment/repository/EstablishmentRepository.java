package com.kot.establishment.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.establishment.entity.EstablishmentEntity;

@Repository
public interface EstablishmentRepository extends CrudRepository<EstablishmentEntity, Long>,
		JpaSpecificationExecutor<EstablishmentEntity>,
		PagingAndSortingRepository<EstablishmentEntity, Long>,
		QuerydslPredicateExecutor<EstablishmentEntity> {
}
