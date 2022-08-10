package com.kot.service;

import java.util.List;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.kot.dao.EstablishmentDao;
import com.kot.entity.EstablishmentEntity;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentDao establishmentDao;

    public EstablishmentEntity create(EstablishmentEntity entity) {
        return establishmentDao.save(entity);
    }

    public EstablishmentEntity update(EstablishmentEntity entity) {
        return establishmentDao.save(entity);
    }

    public EstablishmentEntity findById(Long id) {
        return establishmentDao.findById(id);
    }

    public EstablishmentEntity findOne(BooleanExpression booleanExpression) {
        return establishmentDao.findOne(booleanExpression);
    }

    public void delete(Long id) {
        establishmentDao.delete(id);
    }

    public void delete(EstablishmentEntity establishmentEntity) {
        establishmentDao.delete(establishmentEntity);
    }

    public List<EstablishmentEntity> findAll() {
        return establishmentDao.findAll();
    }

    public Page<EstablishmentEntity> findAll(Pageable pageable) {
        return establishmentDao.findAll(pageable);
    }

    public Page<EstablishmentEntity> findAll(Predicate predicate) {
        return establishmentDao.findAll(predicate);
    }

    public Page<EstablishmentEntity> findAll(Predicate predicate, Pageable pageable) {
        return establishmentDao.findAll(predicate, pageable);
    }

    public Page<EstablishmentEntity> findAll(Predicate predicate, Sort sort) {
        return establishmentDao.findAll(predicate, sort);
    }

    public Page<EstablishmentEntity> findAll(Predicate predicate, Pageable pageable, Sort sort) {
        return establishmentDao.findAll(predicate, pageable, sort);
    }

}
