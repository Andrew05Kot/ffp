package com.kot.repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.kot.entity.EstablishmentEntity;

@Repository
public interface EstablishmentRepository extends CrudRepository<EstablishmentEntity, Long>,
        JpaSpecificationExecutor<EstablishmentEntity>,
        PagingAndSortingRepository<EstablishmentEntity, Long>,
        QuerydslPredicateExecutor<EstablishmentEntity> {
}
