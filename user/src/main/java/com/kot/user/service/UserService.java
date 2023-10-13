package com.kot.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kot.user.dao.UserDao;
import com.kot.user.entity.UserEntity;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserEntity create(UserEntity entity) {
        return userDao.create(entity);
    }

    public UserEntity update(UserEntity entity, String id) {
        return userDao.update(entity, id);
    }

    public UserEntity findById(String id) {
        return userDao.findById(id);
    }

    public Page<UserEntity> findAll() {
        return userDao.findAll(null, Pageable.unpaged());
    }

    public Page<UserEntity> findAll(String filter, Pageable pageable) {
        return userDao.findAll(filter, pageable);
    }

    public Page<UserEntity> findAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }
}
