package com.kot.ordering.api.mobile.v1.dishes_list;

import org.springframework.stereotype.Component;

import com.kot.ordering.entity.DishToOrderEntity;
import com.kot.ordering.model.DishToOrder;

@Component
public class DishToOrderMobileV1Mapper {

    public DishToOrder dtoToDomain(DishToOrderMobileV1Request request) {
        DishToOrder dishToOrder = new DishToOrder();
        dishToOrder.setQuantity(request.getQuantity());
        dishToOrder.setDishName(request.getDishName());
        dishToOrder.setDishCategoryName(request.getDishCategoryName());
        dishToOrder.setDishId(request.getDishId());
        dishToOrder.setCategoryId(request.getCategoryId());
        return dishToOrder;
    }

    public DishToOrderMobileV1Response domainToDto(DishToOrder dishToOrder) {
        DishToOrderMobileV1Response response = new DishToOrderMobileV1Response();
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

    public DishToOrderMobileV1Response domainToDto(DishToOrderEntity dishToOrder) {
        DishToOrderMobileV1Response response = new DishToOrderMobileV1Response();
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
