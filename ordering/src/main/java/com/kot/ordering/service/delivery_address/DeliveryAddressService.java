package com.kot.ordering.service.delivery_address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.ordering.entity.DeliveryAddressEntity;
import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.model.DeliveryAddress;
import com.kot.ordering.repository.DeliveryAddressRepository;

@Service
public class DeliveryAddressService {

    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    public DeliveryAddressEntity create(DeliveryAddress model, OrderEntity orderEntity) {
        DeliveryAddressEntity entity = model.getEntity();
        entity.setOrder(orderEntity);
        return deliveryAddressRepository.save(entity);
    }
}
