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

    public Page<UserEntity> getUsersPage(Pageable pageable, String search) {
        BasicPredicateBuilder<UserEntity> builder = new BasicPredicateBuilder<>(UserEntity.class, UserEntity.COLLECTION_NAME);
        builder.from(search);
        BooleanExpression exp = builder.build();
        return userRepository.findAll(exp, pageable);
    }

    public UserEntity createUser(UserEntity request) {
        return userRepository.insert(request);
    }
}
