package com.kot.ordering.service.order;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kot.ordering.client.DishV1Client;
import com.kot.ordering.client.FraudDishV1Response;
import com.kot.ordering.dao.OrderDao;
import com.kot.ordering.entity.DishToOrderEntity;
import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.entity.OrderStatus;
import com.kot.ordering.model.DishToOrder;
import com.kot.ordering.model.Order;
import com.kot.ordering.service.delivery_address.DeliveryAddressService;
import com.kot.ordering.service.user_detail.UserDetailService;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private DishV1Client dishV1Client;

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @Autowired
    private UserDetailService userDetailService;

    public OrderEntity create(Order model) {
        if (model.getDishesToOrder() == null) {
            //TODO throw some Exception
            return null;
        }
        List<Long> selectedDishesIds = model.getDishesToOrder().stream().map(DishToOrder::getDishId).toList();
        model.setTotalPrice(calculateTotalPrice(selectedDishesIds));
        model.setLastModifiedDate(ZonedDateTime.now());
        model.setOrderStatus(OrderStatus.PENDING);
        OrderEntity entity = orderDao.create(model.getEntity());

        onCreatedOrder(entity, model);

        return entity;
    }

    private void onCreatedOrder(OrderEntity entity, Order model) {
        if (model.getDeliveryAddress() != null) {
            entity.setDeliveryAddress(deliveryAddressService.create(model.getDeliveryAddress(), entity));
        }
        if (model.getUserDetail() != null) {
            entity.setUserDetail(userDetailService.create(model.getUserDetail(), entity));
        }
    }

    private BigDecimal calculateTotalPrice(List<Long> selectedDishesIds) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        MathContext mc = new MathContext(3);
        for (Long dishId : selectedDishesIds) {
            FraudDishV1Response dish = dishV1Client.getDishById(dishId);
            totalPrice = totalPrice.add(dish.getPrice(), mc);
        }
        return totalPrice;
    }

    public Order findById(UUID id) {
        OrderEntity entity = orderDao.findById(id);
        return new Order(entity);
    }

    public Page<Order> findAll() {
        Page<OrderEntity> orderEntitiesPage = orderDao.findAll();
        List<Order> ordersPage = orderEntitiesPage
                .getContent()
                .stream()
                .map(Order::new)
                .toList();

        return new PageImpl<>(ordersPage, orderEntitiesPage.getPageable(), orderEntitiesPage.getTotalElements());
    }

    public Page<Order> findAll(String search, Pageable pageable) {
        Page<OrderEntity> orderEntitiesPage = orderDao.findAll(search, pageable);
        List<Order> ordersPage = orderEntitiesPage
                .getContent()
                .stream()
                .map(Order::new)
                .toList();

        return new PageImpl<>(ordersPage, orderEntitiesPage.getPageable(), orderEntitiesPage.getTotalElements());
    }

    public List<Order> findAll(String search) {
        return orderDao.findAll(search)
                .stream()
                .map(Order::new)
                .toList();

    }

    public Page<Order> findAll(Pageable pageable) {
        Page<OrderEntity> orderEntitiesPage = orderDao.findAll(pageable);
        List<Order> ordersPage = orderEntitiesPage
                .getContent()
                .stream()
                .map(Order::new)
                .toList();

        return new PageImpl<>(ordersPage, orderEntitiesPage.getPageable(), orderEntitiesPage.getTotalElements());
    }

    public List<Order> findAllByUser(UUID userId) {
        List<OrderEntity> orderEntities = orderDao.findAllByUser(userId);
        return orderEntities
                .stream()
                .map(Order::new)
                .toList();
    }

}
