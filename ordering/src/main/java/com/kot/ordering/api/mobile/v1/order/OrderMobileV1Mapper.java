package com.kot.ordering.api.mobile.v1.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.ordering.api.mobile.v1.delevery_address.DeliveryAddressMobileV1Mapper;
import com.kot.ordering.api.mobile.v1.dishes_list.DishToOrderMobileV1Mapper;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Mapper;
import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.model.Order;

@Component
public class OrderMobileV1Mapper {

    @Autowired
    private DeliveryAddressMobileV1Mapper deliveryAddressMobileV1Mapper;

    @Autowired
    private UserDetailMobileV1Mapper userDetailMobileV1Mapper;

    @Autowired
    private DishToOrderMobileV1Mapper dishToOrderMobileV1Mapper;

    public Order dtoToDomain(OrderMobileV1Request dto) {
        Order model = new Order();
        model.setDishesToOrder(dto.getDishes().stream().map(dishToOrderMobileV1Mapper::dtoToDomain).toList());
        model.setDeliveryAddress(deliveryAddressMobileV1Mapper.dtoToDomain(dto.getDeliveryAddress()));
        model.setUserDetail(userDetailMobileV1Mapper.dtoToDomain(dto.getUserDetail()));
        model.setPaymentMethod(dto.getPaymentMethod());
        return model;
    }

    public OrderMobileV1Response domainToDto(Order order) {
        OrderMobileV1Response model = new OrderMobileV1Response();
        model.setTotalPrice(order.getTotalPrice());
        if (order.getDishesToOrder() != null) {
            model.setDishesToOrder(order.getDishesToOrder().stream().map(dishToOrderMobileV1Mapper::domainToDto).toList());
        }
        if (order.getDeliveryAddress() != null) {
            model.setDeliveryAddress(deliveryAddressMobileV1Mapper.domainToDto(order.getDeliveryAddress().getEntity()));
        }
        if (order.getUserDetail() != null) {
            model.setUserDetail(userDetailMobileV1Mapper.domainToDto(order.getUserDetail().getEntity()));
        }
        return model;
    }

    public OrderMobileV1Response domainToDto(OrderEntity orderEntity) {
        OrderMobileV1Response response = new OrderMobileV1Response();
        response.setId(orderEntity.getId());
        response.setTotalPrice(orderEntity.getTotalPrice());
        response.setOrderStatus(orderEntity.getOrderStatus());
        response.setPaymentMethod(orderEntity.getPaymentMethod());
        if (orderEntity.getDeliveryAddress() != null) {
            response.setDeliveryAddress(deliveryAddressMobileV1Mapper.domainToDto(orderEntity.getDeliveryAddress()));
        }
        if (orderEntity.getUserDetail() != null) {
            response.setUserDetail(userDetailMobileV1Mapper.domainToDto(orderEntity.getUserDetail()));
        }
        if (orderEntity.getDishesToOrder() != null) {
            response.setDishesToOrder(orderEntity.getDishesToOrder().stream().map(dishToOrderMobileV1Mapper::domainToDto).toList());
        }
        response.setCreatedDate(orderEntity.getCreatedDate());
        response.setLastModifiedDate(orderEntity.getLastModifiedDate());
        return response;
    }
}
