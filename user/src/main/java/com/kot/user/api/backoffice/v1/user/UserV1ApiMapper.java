package com.kot.user.api.backoffice.v1.user;

import java.util.List;

import com.kot.user.entity.UserEntity;

public interface UserV1ApiMapper {

	UserV1Response domainToDto(UserEntity entity, List<String> expandFields);

	UserV1Response domainToDto(UserEntity entity);

	UserEntity dtoToDomain(UserV1Request request);

	void mapUpdateFields(UserV1Request request, UserEntity entity);
}
