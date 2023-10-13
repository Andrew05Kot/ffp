package com.kot.ordering.service.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.kot.ordering.builder.TestOrderBuilder;
import com.kot.ordering.client.DishV1Client;
import com.kot.ordering.client.FraudCategoryV1Response;
import com.kot.ordering.client.FraudDishV1Response;
import com.kot.ordering.dao.OrderDao;
import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.model.Order;
import com.kot.ordering.service.delivery_address.DeliveryAddressService;
import com.kot.ordering.service.user_detail.UserDetailService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderDao orderDao;

    @Mock
    private DishV1Client dishV1Client;

    @Mock
    private DeliveryAddressService deliveryAddressService;

    @Mock
    private UserDetailService userDetailService;

    private static final SecureRandom RANDOM = new SecureRandom();

    private static final TestOrderBuilder TEST_ORDER_BUILDER = new TestOrderBuilder();

    private static final List<FraudDishV1Response> DISHES = List.of(
            getDish("Pancakes"),
            getDish("Hamburger"),
            getDish("Cheeseburger"),
            getDish("Double burger"),
            getDish("Cheese Pizza"),
            getDish("Veggie Pizza"),
            getDish("Pepperoni Pizza"),
            getDish("Margherita Pizza"),
            getDish("Meat Lovers Pizza"),
            getDish("Latte")
    );

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        DISHES.forEach(fraudDishV1Response -> {
            doReturn(fraudDishV1Response).when(dishV1Client).getDishById(fraudDishV1Response.getId());
        });
    }

    @Test
    public void testCreate() {
        Order order = TEST_ORDER_BUILDER.build();
        OrderEntity orderEntity = order.getEntity();

        when(orderDao.create(any())).thenReturn(orderEntity);

        OrderEntity createdEntity = orderService.create(order);

        assertNotNull(createdEntity);
        assertNotNull(createdEntity.getDeliveryAddress());
        assertNotNull(createdEntity.getUserDetail());
        assertEquals(orderEntity, createdEntity);
        verify(orderDao, times(1)).create(any(OrderEntity.class));
    }

//    @Test
//    public void testTotalPriceOnCreate() {
//        Order order = getRandomValidOrder();
//
//        List<FraudDishV1Response> selectedDishes = getRandomDishes();
//        List<Long> selectedDishesIds = selectedDishes.stream().map(FraudDishV1Response::getId).toList();
//        order.setSelectedDishes(selectedDishesIds);
//
//        OrderEntity expectedOrderEntity = order.getEntity();
//        expectedOrderEntity.setTotalPrice(calculateTotalPrice(selectedDishes));
//
//        when(orderDao.create(any())).thenReturn(expectedOrderEntity);
//
//        OrderEntity createdEntity = orderService.create(order);
//
//        assertNotNull(createdEntity);
//        assertEquals(expectedOrderEntity.getTotalPrice(), createdEntity.getTotalPrice());
//        verify(orderDao, times(1)).create(any(OrderEntity.class));
//    }

//    @Test
//    public void testDeliveryAddressOnCreate() {
//        Order order = getRandomValidOrder();
//        order.setDeliveryAddress(getDeliveryAddress());
//        order.setSelectedDishes(getRandomDishesIds());
//
//        DeliveryAddressEntity expectedDeliveryAddress = order.getDeliveryAddress().getEntity();
//        OrderEntity expectedOrderEntity = order.getEntity();
//
//        when(orderDao.create(any())).thenReturn(expectedOrderEntity);
//        when(deliveryAddressService.create(any(), any())).thenReturn(expectedDeliveryAddress);
//
//        OrderEntity createdEntity = orderService.create(order);
//
//        assertNotNull(createdEntity);
//        assertNotNull(createdEntity.getDeliveryAddress());
//        assertEquals(expectedOrderEntity.getDeliveryAddress(), createdEntity.getDeliveryAddress());
//        verify(orderDao, times(1)).create(any(OrderEntity.class));
//    }

//    @Test
//    public void testUserDetailOnCreate() {
//        Order order = getRandomValidOrder();
//        order.setUserDetail(getUserDetail());
//        order.setSelectedDishes(getRandomDishesIds());
//
//        UserDetailEntity expectedUserDetail = order.getUserDetail().getEntity();
//        OrderEntity expectedOrderEntity = order.getEntity();
//
//        when(orderDao.create(any())).thenReturn(expectedOrderEntity);
//        when(userDetailService.create(any(), any())).thenReturn(expectedUserDetail);
//
//        OrderEntity createdEntity = orderService.create(order);
//
//        assertNotNull(createdEntity);
//        assertNotNull(createdEntity.getUserDetail());
//        assertEquals(expectedOrderEntity.getDeliveryAddress(), createdEntity.getDeliveryAddress());
//        verify(orderDao, times(1)).create(any(OrderEntity.class));
//    }

    @Test
    public void testFindAllWithPageable() {
        Pageable pageable = PageRequest.of(0, 10);
        List<OrderEntity> orderEntities = generateOrderEntities(10);
        Page<OrderEntity> mockedPage = new PageImpl<>(orderEntities, pageable, orderEntities.size());

        when(orderDao.findAll(pageable)).thenReturn(mockedPage);

        Page<Order> resultPage = orderService.findAll(pageable);

        assertNotNull(resultPage);
        assertEquals(mockedPage.getTotalElements(), resultPage.getTotalElements());
        assertEquals(mockedPage.getNumber(), resultPage.getNumber());
        assertEquals(mockedPage.getSize(), resultPage.getSize());

        List<Order> resultOrders = resultPage.getContent();
        assertEquals(orderEntities.size(), resultOrders.size());

        for (int i = 0; i < orderEntities.size(); i++) {
            OrderEntity entity = orderEntities.get(i);
            Order order = resultOrders.get(i);
            assertEquals(entity, order.getEntity());
        }

        verify(orderDao, times(1)).findAll(pageable);
    }

    private List<OrderEntity> generateOrderEntities(int count) {
        List<OrderEntity> entities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            OrderEntity entity = getRandomValidOrder().getEntity();
            entities.add(entity);
        }
        return entities;
    }

    private Order getRandomValidOrder() {
        return TEST_ORDER_BUILDER.build();
    }

    private List<Long> getRandomDishesIds() {
        int count = (int) (Math.random() * DISHES.size()) + 1;
        List<FraudDishV1Response> selectedDishes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            selectedDishes.add(DISHES.get(i));
        }
        return selectedDishes.stream().map(FraudDishV1Response::getId).toList();
    }

    private List<FraudDishV1Response> getRandomDishes() {
        int count = (int) (Math.random() * DISHES.size()) + 1;
        List<FraudDishV1Response> selectedDishes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            selectedDishes.add(DISHES.get(i));
        }
        return selectedDishes;
    }

    private static FraudDishV1Response getDish(String name) {
        FraudDishV1Response dishV1Response = new FraudDishV1Response();
        dishV1Response.setId(RANDOM.nextLong());
        dishV1Response.setName(name);
        dishV1Response.setPrice(BigDecimal.valueOf(RANDOM.nextInt(10) + 1));
        dishV1Response.setDescription("Description " + RANDOM.nextLong());
        dishV1Response.setCategory(getTestCategory());
        return dishV1Response;
    }

    private static FraudCategoryV1Response getTestCategory() {
        FraudCategoryV1Response categoryV1Response = new FraudCategoryV1Response();
        categoryV1Response.setId(RANDOM.nextLong());
        categoryV1Response.setName("Hello");
        categoryV1Response.setDescription("world");
        return categoryV1Response;
    }

    private BigDecimal calculateTotalPrice(List<FraudDishV1Response> selectedDishes) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        MathContext mc = new MathContext(3);
        for (FraudDishV1Response dish : selectedDishes) {
            totalPrice = totalPrice.add(dish.getPrice(), mc);
        }
        return totalPrice;
    }

}
