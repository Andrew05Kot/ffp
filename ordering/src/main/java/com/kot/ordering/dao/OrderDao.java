package com.kot.ordering.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.repository.OrderRepository;

@Service
public class OrderDao {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity create(OrderEntity entity) {
        return this.orderRepository.save(entity);
    }

    public OrderEntity update(OrderEntity entity, UUID id) {
        return this.orderRepository.save(entity);
    }

    public OrderEntity findById(UUID id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Page<OrderEntity> findAll() {
        return orderRepository.findAll(Specification.where(null), Pageable.unpaged());
    }

    public Page<OrderEntity> findAll(String filter, Pageable pageable) {
        return orderRepository.findAll(buildSpecification(filter), pageable);
    }

    public List<OrderEntity> findAll(String filter) {
        return orderRepository.findAll(buildSpecification(filter));
    }

    public Page<OrderEntity> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    protected Specification<OrderEntity> addSpecifications() {
        return Specification.where(null);
    }

    protected Specification<OrderEntity> addAdditionalSpecificationsForGet() {
        return null;
    }

    private Specification<OrderEntity> buildSpecification(String filter) {
        Specification<OrderEntity> filteringSpecification = null;
//        if (filter != null) {
//            List<FilteringCriteria> searchCriteria = filteringCriteriaParser
//                    .parseSearchCriteria(filter, userSpecificationsBuilder.getAllowedFilterableProperties());
//            filteringSpecification = userSpecificationsBuilder.buildSpecification(searchCriteria);
//        }
        return filteringSpecification;
    }
}
