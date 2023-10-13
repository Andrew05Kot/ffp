package com.kot.ordering.api.mobile.v1.delevery_address;

import org.springframework.stereotype.Component;

import com.kot.ordering.entity.DeliveryAddressEntity;
import com.kot.ordering.model.DeliveryAddress;

@Component
public class DeliveryAddressMobileV1Mapper {

    public DeliveryAddress dtoToDomain(DeliveryAddressMobileV1Request request) {
        DeliveryAddress model = new DeliveryAddress();
        model.setCountry(request.getCountry());
        model.setCity(request.getCity());
        model.setStreet(request.getStreet());
        model.setHouseNumber(request.getHouseNumber());
        model.setAdditionalInfo(request.getAdditionalInfo());
        return model;
    }

    public DeliveryAddressMobileV1Response domainToDto(DeliveryAddressEntity entity) {
        DeliveryAddressMobileV1Response response = new DeliveryAddressMobileV1Response();
        response.setId(entity.getId());
        response.setCountry(entity.getCountry());
        response.setCity(entity.getCity());
        response.setStreet(entity.getStreet());
        response.setHouseNumber(entity.getHouseNumber());
        response.setAdditionalInfo(entity.getAdditionalInfo());
        return response;
    }
}
