package com.kot.service;

import com.kot.entity.UserEntity;
import com.kot.repository.UserRepository;
import com.kot.searching.BasicPredicateBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<UserEntity> getUsersPage(Pageable pageable, Predicate predicate) {
//        Query query = new Query();
//        query.with(pageable);
        return userRepository.findAll(pageable);
    }

    public UserEntity createUser(UserEntity request) {
        return userRepository.insert(request);
    }
}
