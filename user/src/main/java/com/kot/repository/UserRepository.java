package com.kot.repository;

import com.kot.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.function.Predicate;

//@Repository
public interface UserRepository extends MongoRepository<UserEntity, String>, QuerydslPredicateExecutor<UserEntity> {

    Page<UserEntity> findAll(Pageable pageable);

//    Page<UserEntity> findAll(Pageable pageable, Predicate predicate);
}
