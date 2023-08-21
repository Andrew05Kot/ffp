package com.kot.user.api.backoffice.v1.user;

import java.util.List;
import org.springframework.stereotype.Component;

import com.kot.user.entity.UserEntity;

@Component
public class UserV1ApiMapperImpl implements UserV1ApiMapper {

	public UserV1Response domainToDto(UserEntity entity, List<String> expandFields) {
		UserV1Response response = new UserV1Response();
		response.setId(entity.getId());
		response.setFirstName(entity.getFirstName());
		response.setLastName(entity.getLastName());
		response.setBirthday(entity.getBirthday());
		response.setCountry(entity.getCountry());
		response.setCity(entity.getCity());
		response.setStreet(entity.getStreet());
		response.setHouseNumber(entity.getHouseNumber());
		response.setCreatedDate(entity.getCreatedDate());
		response.setLastModifiedDate(entity.getLastModifiedDate());
		return response;
	}

	public UserV1Response domainToDto(UserEntity entity) {
		return domainToDto(entity, null);
	}

	public UserEntity dtoToDomain(UserV1Request request) {
		UserEntity entity = new UserEntity();
		entity.setId(request.getId());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setBirthday(request.getBirthday());
		entity.setCountry(request.getCountry());
		entity.setCity(request.getCity());
		entity.setStreet(request.getStreet());
		entity.setHouseNumber(request.getHouseNumber());
		return entity;
	}

	public void mapUpdateFields(UserV1Request request, UserEntity entity) {
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setBirthday(request.getBirthday());
		entity.setCountry(request.getCountry());
		entity.setCity(request.getCity());
		entity.setStreet(request.getStreet());
		entity.setHouseNumber(request.getHouseNumber());
	}
}
