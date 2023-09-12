package com.kot.ordering.api.mobile.v1.user_details;

import org.springframework.stereotype.Component;

import com.kot.ordering.entity.UserDetailEntity;
import com.kot.ordering.model.UserDetail;

@Component
public class UserDetailMobileV1Mapper {

    public UserDetail dtoToDomain(UserDetailMobileV1Request request) {
        UserDetail model = new UserDetail();
        model.setFirstName(request.getFirstName());
        model.setLastName(request.getLastName());
        model.setEmail(request.getEmail());
        model.setPhoneNumber(request.getPhoneNumber());
        model.setImageUrl(request.getImageUrl());
        return model;
    }

    public UserDetailMobileV1Response domainToDto(UserDetailEntity model) {
        UserDetailMobileV1Response response = new UserDetailMobileV1Response();
        response.setId(model.getId());
        response.setFirstName(model.getFirstName());
        response.setLastName(model.getLastName());
        response.setEmail(model.getEmail());
        response.setPhoneNumber(model.getPhoneNumber());
        response.setImageUrl(model.getImageUrl());
        return response;
    }
}
