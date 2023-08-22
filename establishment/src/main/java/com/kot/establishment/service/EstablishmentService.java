package com.kot.establishment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.establishment.dao.EstablishmentDao;
import com.kot.establishment.entity.EstablishmentEntity;
import com.kot.establishment.filtering.criteria_parser.FilteringCriteria;
import com.kot.establishment.filtering.criteria_parser.FilteringCriteriaParser;
import com.kot.establishment.filtering.models.establishment.EstablishmentSpecificationsBuilder;

@Service
public class EstablishmentService {

	@Autowired
	private EstablishmentDao establishmentDao;

	@Autowired
	private FilteringCriteriaParser searchCriteriaParser;

	private final EstablishmentSpecificationsBuilder establishmentSpecificationsBuilder = new EstablishmentSpecificationsBuilder();

	public EstablishmentEntity create(EstablishmentEntity entity) {
		return establishmentDao.save(entity);
	}

	public EstablishmentEntity update(EstablishmentEntity entity) {
		return establishmentDao.save(entity);
	}

	public EstablishmentEntity findById(Long id) {
		return establishmentDao.findById(id);
	}

	public void delete(Long id) {
		establishmentDao.delete(id);
	}

	public void delete(EstablishmentEntity establishmentEntity) {
		establishmentDao.delete(establishmentEntity);
	}

	public Page<EstablishmentEntity> findAll() {
		return establishmentDao.findAll();
	}

	public Page<EstablishmentEntity> findAll(String search, Pageable pageable) {
		Specification<EstablishmentEntity> specification = buildSpecification(search);
		return establishmentDao.findAll(specification, pageable);
	}

	public Page<EstablishmentEntity> findAll(Specification<EstablishmentEntity> filter, Pageable pageable) {
		return establishmentDao.findAll(filter, pageable);
	}

	public List<EstablishmentEntity> findAll(Specification<EstablishmentEntity> specification) {
		return establishmentDao.findAll(specification);
	}

	public Page<EstablishmentEntity> findAll(Pageable pageable) {
		return establishmentDao.findAll(pageable);
	}

	private Specification<EstablishmentEntity> buildSpecification(String filter) {
		Specification<EstablishmentEntity> filteringSpecification = null;
		if (filter != null) {
			List<FilteringCriteria> searchCriteria = searchCriteriaParser.parseSearchCriteria(filter,
					establishmentSpecificationsBuilder.getAllowedFilterableProperties());
			filteringSpecification = establishmentSpecificationsBuilder.buildSpecification(searchCriteria);
		}
		return filteringSpecification;
	}

}
