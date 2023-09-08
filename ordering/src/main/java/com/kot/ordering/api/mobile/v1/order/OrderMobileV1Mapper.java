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

    public OrderV1MobileResponse modelToDto(Order order) {
        OrderV1MobileResponse model = new OrderV1MobileResponse();
        model.setId(order.getId());
        model.setCardName(order.getCardName());
        model.setCardNumber(order.getCardNumber());
        model.setTotalPrice(order.getTotalPrice());
        model.setExpiration(order.getExpiration());
        model.setCvv(order.getCvv());
        model.setPaymentMethod(order.getPaymentMethod());
        model.setDeliveryAddress(deliveryAddressMobileV1Mapper.domainToDto(order.getDeliveryAddress().getEntity()));
        model.setUserDetail(userDetailMobileV1Mapper.domainToDto(order.getUserDetail().getEntity()));
        return model;
    }

    public OrderV1MobileResponse domainToDto(OrderEntity orderEntity) {
        OrderV1MobileResponse response = new OrderV1MobileResponse();
        response.setId(orderEntity.getId());
        response.setCardName(orderEntity.getCardName());
        response.setCardNumber(orderEntity.getCardNumber());
        response.setTotalPrice(orderEntity.getTotalPrice());
        response.setExpiration(orderEntity.getExpiration());
        response.setCvv(orderEntity.getCvv());
        response.setPaymentMethod(orderEntity.getPaymentMethod());
        response.setDeliveryAddress(deliveryAddressMobileV1Mapper.domainToDto(orderEntity.getDeliveryAddress()));
        response.setUserDetail(userDetailMobileV1Mapper.domainToDto(orderEntity.getUserDetail()));
//        model.setSelectedDishes(order.getSelectedDishes());
        return response;
    }
}
