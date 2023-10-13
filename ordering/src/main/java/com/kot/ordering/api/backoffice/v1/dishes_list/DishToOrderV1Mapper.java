package com.kot.ordering.api.backoffice.v1.dishes_list;

import org.springframework.stereotype.Component;

import com.kot.ordering.entity.DishToOrderEntity;
import com.kot.ordering.model.DishToOrder;

@Component
public class DishToOrderV1Mapper {

    public DishToOrderV1Response domainToDto(DishToOrder dishToOrder) {
        DishToOrderV1Response response = new DishToOrderV1Response();
        response.setId(dishToOrder.getId());
        response.setQuantity(dishToOrder.getQuantity());
        response.setDishId(dishToOrder.getDishId());
        response.setDishName(dishToOrder.getDishName());
        response.setCategoryId(dishToOrder.getCategoryId());
        response.setDishCategoryName(dishToOrder.getDishCategoryName());
        response.setCreatedDate(dishToOrder.getCreatedDate());
        response.setLastModifiedDate(dishToOrder.getLastModifiedDate());
        return response;
    }

    public DishToOrderV1Response domainToDto(DishToOrderEntity dishToOrder) {
        DishToOrderV1Response response = new DishToOrderV1Response();
        response.setId(dishToOrder.getId());
        response.setQuantity(dishToOrder.getQuantity());
        response.setDishId(dishToOrder.getDishId());
        response.setDishName(dishToOrder.getDishName());
        response.setCategoryId(dishToOrder.getCategoryId());
        response.setDishCategoryName(dishToOrder.getDishCategoryName());
        response.setCreatedDate(dishToOrder.getCreatedDate());
        response.setLastModifiedDate(dishToOrder.getLastModifiedDate());
        return response;
    }
}
