package com.kot.establishment.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.establishment.entity.EstablishmentEntity;
import com.kot.establishment.repository.EstablishmentRepository;

@Service
public class EstablishmentDao {

	@Autowired
	private EstablishmentRepository establishmentRepository;

	public EstablishmentEntity save(EstablishmentEntity entity) {
		return establishmentRepository.save(entity);
	}

	public EstablishmentEntity findById(Long id) {
		Optional<EstablishmentEntity> establishmentEntity = establishmentRepository.findById(id);
		if (establishmentEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return establishmentEntity.get();
	}

	public EstablishmentEntity findOne(Predicate predicate) {
		Optional<EstablishmentEntity> establishmentEntity = establishmentRepository.findOne(predicate);
		if (establishmentEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return establishmentEntity.get();
	}

	public void delete(Long id) {
		establishmentRepository.deleteById(id);
	}

	public void delete(EstablishmentEntity establishmentEntity) {
		establishmentRepository.delete(establishmentEntity);
	}

	public Page<EstablishmentEntity> findAll() {
		return establishmentRepository.findAll(Specification.where(null), Pageable.unpaged());
	}

	public Page<EstablishmentEntity> findAll(Specification<EstablishmentEntity> filter, Pageable pageable) {
		return establishmentRepository.findAll(filter, pageable);
	}

	public List<EstablishmentEntity> findAll(Specification<EstablishmentEntity> specification) {
		return establishmentRepository.findAll(specification);
	}

	public Page<EstablishmentEntity> findAll(Pageable pageable) {
		Sort sort = pageable.getSort();
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

		return establishmentRepository.findAll(pageRequest);
	}

}
