package com.kot.dish.api.backoffice.v1.infrastructure;

import java.util.List;

public interface ApiV1Mapper<Entity, Response, Request> {

	Response domainToDto(Entity entity, List<String> expandFields);

	Response domainToDto(Entity entity);

	Entity dtoToDomain(Request dto);
}
