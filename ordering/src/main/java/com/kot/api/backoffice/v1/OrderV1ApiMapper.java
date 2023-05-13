package com.kot.api.backoffice.v1;

import com.kot.bll.order.Order;
import com.kot.intercomm.client.DishV1Client;
import com.kot.intercomm.client.FraudDishV1Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderV1ApiMapper {

    @Autowired
    private DishV1Client dishClient;

    public OrderV1Response modelToDto(Order model, List<String> expandFields) {
        OrderV1Response response = new OrderV1Response();
        response.setId(model.getId());
        response.setCreatedDate(model.getCreatedDate());
        response.setLastModifiedDate(model.getLastModifiedDate());
        response.setCardName(model.getCardName());
        response.setCardNumber(model.getCardNumber());
        response.setExpiration(model.getExpiration());
        response.setPaymentMethod(model.getPaymentMethod());
        response.setTotalPrice(model.getTotalPrice());
        expandResponse(response, model, expandFields);
        return response;
    }

    public void expandResponse(OrderV1Response response, Order model, List<String> entitiesToExpand) {
        if (entitiesToExpand == null) {
            return;
        }
        if (entitiesToExpand.contains("dishes")) {
            List<FraudDishV1Response> fraudDishV1ResponseList = model.getSelectedDishes().stream().map(dishId -> dishClient.getDishById(dishId)).toList();
            response.setSelectedDishes(fraudDishV1ResponseList);
            response.setSelectedCategories(fraudDishV1ResponseList.stream().map(dish -> dish.getCategory().getName()).toList());
        }
    }
}
