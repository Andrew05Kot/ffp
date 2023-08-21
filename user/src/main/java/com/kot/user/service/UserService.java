package com.kot.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
		return userDao.findAll(Specification.where(null), Pageable.unpaged());
	}

	public Page<UserEntity> findAll(Specification<UserEntity> filter, Pageable pageable) {
		return userDao.findAll(filter, pageable);
	}

	public List<UserEntity> findAll(Specification<UserEntity> specification) {
		return userDao.findAll(specification);
	}

	public Page<UserEntity> findAll(Pageable pageable) {
		return userDao.findAll(pageable);
	}
}
