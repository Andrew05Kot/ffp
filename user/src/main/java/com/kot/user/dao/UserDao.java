package com.kot.user.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.user.entity.UserEntity;
import com.kot.user.repository.UserRepository;

@Service
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public UserEntity create(UserEntity entity) {
		return userRepository.save(entity);
	}

	public UserEntity update(UserEntity entity, String id) {
		return userRepository.save(entity);
	}

	public UserEntity findById(String id) {
		return userRepository.findById(UUID.fromString(id)).orElse(null);
	}

	public Page<UserEntity> findAll() {
		return userRepository.findAll(Specification.where(null), Pageable.unpaged());
	}

	public Page<UserEntity> findAll(Specification<UserEntity> filter, Pageable pageable) {
		return userRepository.findAll(filter, pageable);
	}

	public List<UserEntity> findAll(Specification<UserEntity> specification) {
		return userRepository.findAll(specification);
	}

	public Page<UserEntity> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
}
