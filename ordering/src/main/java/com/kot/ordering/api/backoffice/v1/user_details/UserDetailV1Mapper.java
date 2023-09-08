package com.kot.ordering.api.backoffice.v1.user_details;

import org.springframework.stereotype.Component;

import com.kot.ordering.entity.UserDetailEntity;
import com.kot.ordering.model.UserDetail;

@Component
public class UserDetailV1Mapper {

    public UserDetailV1Response domainToDto(UserDetailEntity model) {
        UserDetailV1Response response = new UserDetailV1Response();
        response.setId(model.getId());
        response.setFirstName(model.getFirstName());
        response.setLastName(model.getLastName());
        response.setEmail(model.getEmail());
        response.setPhoneNumber(model.getPhoneNumber());
        response.setImageUrl(model.getImageUrl());
        return response;
    }
}
