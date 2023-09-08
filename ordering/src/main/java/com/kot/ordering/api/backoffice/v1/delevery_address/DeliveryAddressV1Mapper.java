package com.kot.ordering.api.backoffice.v1.delevery_address;

import org.springframework.stereotype.Component;

import com.kot.ordering.entity.DeliveryAddressEntity;
import com.kot.ordering.model.DeliveryAddress;

@Component
public class DeliveryAddressV1Mapper {

    public DeliveryAddressV1Response domainToDto(DeliveryAddressEntity entity) {
        DeliveryAddressV1Response response = new DeliveryAddressV1Response();
        response.setId(entity.getId());
        response.setCountry(entity.getCountry());
        response.setCity(entity.getCity());
        response.setStreet(entity.getStreet());
        response.setHouseNumber(entity.getHouseNumber());
        response.setAdditionalInfo(entity.getAdditionalInfo());
        return response;
    }
}
