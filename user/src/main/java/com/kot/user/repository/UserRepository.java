package com.kot.user.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.user.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID>,
		JpaSpecificationExecutor<UserEntity>,
		PagingAndSortingRepository<UserEntity, UUID> {
}
