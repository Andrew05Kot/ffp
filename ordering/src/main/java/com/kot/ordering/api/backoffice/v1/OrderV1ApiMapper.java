package com.kot.ordering.api.backoffice.v1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.ordering.api.backoffice.v1.delevery_address.DeliveryAddressV1Mapper;
import com.kot.ordering.api.backoffice.v1.dishes_list.DishToOrderV1Mapper;
import com.kot.ordering.api.backoffice.v1.user_details.UserDetailV1Mapper;
import com.kot.ordering.client.DishV1Client;
import com.kot.ordering.model.Order;
import com.kot.ordering.service.user_detail.UserDetailService;

@Component
public class OrderV1ApiMapper {

    @Autowired
    private DishV1Client dishClient;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private DeliveryAddressV1Mapper deliveryAddressV1Mapper;

    @Autowired
    private UserDetailV1Mapper userDetailV1Mapper;

    @Autowired
    private DishToOrderV1Mapper dishToOrderV1Mapper;

    public OrderV1Response domainToDto(Order order, List<String> expandFields) {
        OrderV1Response response = new OrderV1Response();
        response.setId(order.getId());
        response.setTotalPrice(order.getTotalPrice());
        response.setOrderStatus(order.getOrderStatus());
        response.setPaymentMethod(order.getPaymentMethod());
        if (order.getDishesToOrder() != null) {
            response.setDishesToOrder(order.getDishesToOrder().stream().map(dishToOrderV1Mapper::domainToDto).toList());
        }
        if (order.getDeliveryAddress() != null) {
            response.setDeliveryAddress(deliveryAddressV1Mapper.domainToDto(order.getDeliveryAddress().getEntity()));
        }
        if (order.getUserDetail() != null) {
            response.setUserDetail(userDetailV1Mapper.domainToDto(order.getUserDetail().getEntity()));
        }
        expandResponse(response, order, expandFields);
        return response;
    }

    public void expandResponse(OrderV1Response response, Order order, List<String> entitiesToExpand) {
        if (entitiesToExpand == null) {
            return;
        }
//        if (entitiesToExpand.contains("dishes")) {
//            List<FraudDishV1Response> fraudDishV1ResponseList = order.getSelectedDishes().stream().map(dishId -> dishClient.getDishById(dishId)).toList();
//            response.setSelectedDishes(fraudDishV1ResponseList);
//            response.setSelectedCategories(fraudDishV1ResponseList.stream().map(dish -> dish.getCategory().getName()).toList());
//        }
        if (entitiesToExpand.contains("userDetails")) {
//            response.setUserDetail(userDetailService.findByOrderId(order.getId()));
//			response.setSelectedDishes(fraudDishV1ResponseList);
//			response.setSelectedCategories(fraudDishV1ResponseList.stream().map(dish -> dish.getCategory().getName()).toList());
        }
    }
}
