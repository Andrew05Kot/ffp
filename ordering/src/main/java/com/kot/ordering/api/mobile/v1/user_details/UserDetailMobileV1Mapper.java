package com.kot.ordering.api.mobile.v1.user_details;

import org.springframework.stereotype.Component;

import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.entity.UserDetailEntity;
import com.kot.ordering.model.UserDetail;

@Component
public class UserDetailMobileV1Mapper {

    public UserDetail dtoToDomain(UserDetailV1MobileRequest request) {
        UserDetail model = new UserDetail();
        model.setFirstName(request.getFirstName());
        model.setLastName(request.getLastName());
        model.setEmail(request.getEmail());
        model.setPhoneNumber(request.getPhoneNumber());
        model.setImageUrl(request.getImageUrl());
        return model;
    }

    public UserDetailV1MobileResponse modelToDto(UserDetail model) {
        UserDetailV1MobileResponse response = new UserDetailV1MobileResponse();
        response.setId(model.getId());
        response.setFirstName(model.getFirstName());
        response.setLastName(model.getLastName());
        response.setEmail(model.getEmail());
        response.setPhoneNumber(model.getPhoneNumber());
        response.setImageUrl(model.getImageUrl());
        return response;
    }

    public UserDetailV1MobileResponse domainToDto(UserDetailEntity model) {
        UserDetailV1MobileResponse response = new UserDetailV1MobileResponse();
        response.setId(model.getId());
        response.setFirstName(model.getFirstName());
        response.setLastName(model.getLastName());
        response.setEmail(model.getEmail());
        response.setPhoneNumber(model.getPhoneNumber());
        response.setImageUrl(model.getImageUrl());
        return response;
    }
}
