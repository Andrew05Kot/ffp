package com.kot.user.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.user.entity.UserEntity;
import com.kot.user.filtering.criteria_parser.FilteringCriteria;
import com.kot.user.filtering.criteria_parser.FilteringCriteriaParser;
import com.kot.user.filtering.models.user.UserSpecificationsBuilder;
import com.kot.user.repository.UserRepository;

@Service
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FilteringCriteriaParser filteringCriteriaParser;

	private final UserSpecificationsBuilder userSpecificationsBuilder = new UserSpecificationsBuilder();

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

	public Page<UserEntity> findAll(String filter, Pageable pageable) {
		return userRepository.findAll(buildSpecification(filter), pageable);
	}

	public List<UserEntity> findAll(String filter) {
		return userRepository.findAll(buildSpecification(filter));
	}

	public Page<UserEntity> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	private Specification<UserEntity> buildSpecification(String filter) {
		Specification<UserEntity> filteringSpecification = null;
		if (filter != null) {
			List<FilteringCriteria> searchCriteria = filteringCriteriaParser
					.parseSearchCriteria(filter, userSpecificationsBuilder.getAllowedFilterableProperties());
			filteringSpecification = userSpecificationsBuilder.buildSpecification(searchCriteria);
		}
		return filteringSpecification;
	}
}
