package com.kot.bll.order;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.kot.dal.domain.OrderEntity;

@Mapper
public interface OrderBLLMapper {

	OrderBLLMapper INSTANCE = Mappers.getMapper(OrderBLLMapper.class);

	Order entityToModel(OrderEntity entity);

	OrderEntity modelToEntity(Order model);
}
