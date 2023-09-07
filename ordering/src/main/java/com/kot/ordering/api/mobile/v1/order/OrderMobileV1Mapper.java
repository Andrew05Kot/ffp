package com.kot.ordering.api.mobile.v1.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.ordering.api.mobile.v1.delevery_address.DeliveryAddressMobileV1Mapper;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Mapper;
import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.model.Order;

@Component
public class OrderMobileV1Mapper {

    @Autowired
    private DeliveryAddressMobileV1Mapper deliveryAddressMobileV1Mapper;

    @Autowired
    private UserDetailMobileV1Mapper userDetailMobileV1Mapper;

    public Order dtoToDomain(OrderMobileV1Request dto) {
        Order model = new Order();
        model.setCardName(dto.getCardName());
        model.setCardNumber(dto.getCardNumber());
        model.setExpiration(dto.getExpiration());
        model.setCvv(dto.getCvv());
        model.setPaymentMethod(dto.getPaymentMethod());
        model.setSelectedDishes(dto.getDishIds());
        model.setDeliveryAddress(deliveryAddressMobileV1Mapper.dtoToDomain(dto.getDeliveryAddress()));
        model.setUserDetail(userDetailMobileV1Mapper.dtoToDomain(dto.getUserDetail()));
        return model;
    }

    public OrderMobileV1Response modelToDto(Order order) {
        OrderMobileV1Response model = new OrderMobileV1Response();
        model.setId(order.getId());
        model.setCardName(order.getCardName());
        model.setCardNumber(order.getCardNumber());
        model.setTotalPrice(order.getTotalPrice());
        model.setExpiration(order.getExpiration());
        model.setCvv(order.getCvv());
        model.setPaymentMethod(order.getPaymentMethod());
        model.setDeliveryAddress(deliveryAddressMobileV1Mapper.modelToDto(order.getDeliveryAddress()));
        model.setUserDetail(userDetailMobileV1Mapper.modelToDto(order.getUserDetail()));
        return model;
    }

    public OrderMobileV1Response domainToDto(OrderEntity order) {
        OrderMobileV1Response response = new OrderMobileV1Response();
        response.setId(order.getId());
        response.setCardName(order.getCardName());
        response.setCardNumber(order.getCardNumber());
        response.setTotalPrice(order.getTotalPrice());
        response.setExpiration(order.getExpiration());
        response.setCvv(order.getCvv());
        response.setPaymentMethod(order.getPaymentMethod());
        response.setDeliveryAddress(deliveryAddressMobileV1Mapper.domainToDto(order.getDeliveryAddress()));
        response.setUserDetail(userDetailMobileV1Mapper.domainToDto(order.getUserDetail()));
//        model.setSelectedDishes(order.getSelectedDishes());
        return response;
    }
}
