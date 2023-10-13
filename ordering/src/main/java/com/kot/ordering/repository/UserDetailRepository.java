package com.kot.ordering.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.ordering.entity.UserDetailEntity;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetailEntity, UUID>,
        JpaSpecificationExecutor<UserDetailEntity>,
        PagingAndSortingRepository<UserDetailEntity, UUID> {

    UserDetailEntity findByOrder_Id(UUID orderId);

}

