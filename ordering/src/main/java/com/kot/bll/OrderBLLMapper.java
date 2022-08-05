package com.kot.bll;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.kot.dal.OrderEntity;

@Mapper
public interface OrderBLLMapper {

	OrderBLLMapper INSTANCE = Mappers.getMapper(OrderBLLMapper.class);

	Order entityToModel(OrderEntity entity);

	OrderEntity modelToEntity(Order model);
}
