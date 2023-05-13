package com.kot.dish.bll.service;

import com.kot.dish.bll.filtering.DishSpecificationsBuilder;
import com.kot.dish.bll.filtering.FilteringCriteria;
import com.kot.dish.bll.filtering.FilteringCriteriaParser;
import com.kot.dish.bll.mapper.DishBLLMapper;
import com.kot.dish.bll.model.Dish;
import com.kot.dish.dal.dao.DishDao;
import com.kot.dish.dal.entity.DishEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishDao dishDao;

    @Autowired
    private FilteringCriteriaParser searchCriteriaParser;

    private final DishSpecificationsBuilder dishSpecificationsBuilder =  new DishSpecificationsBuilder();

    public Dish save(Dish dish) {
        DishEntity dishEntity = dishDao.save(DishBLLMapper.INSTANCE.modelToEntity(dish), dish.getId());
        return DishBLLMapper.INSTANCE.entityToModel(dishEntity);
    }

    public Dish findById(Long id) {
        return DishBLLMapper.INSTANCE.entityToModel(dishDao.findById(id));
    }

    public Page<Dish> findAll() {
        return dishDao.findAll().map(DishBLLMapper.INSTANCE::entityToModel);
    }

    public Page<Dish> findAll(String search, Pageable pageable) {
        Specification<DishEntity> specification = buildSpecification(search);
        return dishDao.findAll(specification, pageable).map(DishBLLMapper.INSTANCE::entityToModel);
    }

    public Page<Dish> findAll(Specification<DishEntity> filter, Pageable pageable) {
        return dishDao.findAll(filter, pageable).map(DishBLLMapper.INSTANCE::entityToModel);
    }

    public Page<Dish> findAll(Specification specification) {
        return dishDao.findAll(specification).map(DishBLLMapper.INSTANCE::entityToModel);
    }


    public Page<Dish> findAll(Pageable pageable) {
        return dishDao.findAll(pageable).map(DishBLLMapper.INSTANCE::entityToModel);
    }

    private Specification<DishEntity> buildSpecification(String filter) {
        Specification<DishEntity> filteringSpecification = null;
        if (filter != null) {
            List<FilteringCriteria> searchCriteria = searchCriteriaParser.parseSearchCriteria(filter,
                   this.dishSpecificationsBuilder.getFilterableProperties());
            filteringSpecification = this.dishSpecificationsBuilder.buildSpecification(searchCriteria);
        }
        return filteringSpecification;
    }
}
