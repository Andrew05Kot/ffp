package com.kot.ordering.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.ordering.entity.OrderEntity;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, UUID>,
        JpaSpecificationExecutor<OrderEntity>,
        PagingAndSortingRepository<OrderEntity, UUID> {
}
