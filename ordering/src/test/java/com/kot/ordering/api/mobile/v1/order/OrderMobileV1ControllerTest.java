package com.kot.ordering.api.mobile.v1.order;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.kot.ordering.api.mobile.v1.delevery_address.DeliveryAddressMobileV1Request;
import com.kot.ordering.api.mobile.v1.delevery_address.DeliveryAddressMobileV1Response;
import com.kot.ordering.api.mobile.v1.dishes_list.DishToOrderMobileV1Request;
import com.kot.ordering.api.mobile.v1.dishes_list.DishToOrderMobileV1Response;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Request;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Response;
import com.kot.ordering.builder.TestOrderBuilder;
import com.kot.ordering.model.DeliveryAddress;
import com.kot.ordering.model.DishToOrder;
import com.kot.ordering.model.Order;
import com.kot.ordering.model.UserDetail;
import com.kot.ordering.service.order.OrderService;

@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
class OrderMobileV1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @MockBean
    private OrderService orderService;

    private static final TestOrderBuilder TEST_ORDER_BUILDER = new TestOrderBuilder();

    private static final Order TEST_ORDER = TEST_ORDER_BUILDER.build();
    private static final DeliveryAddress TEST_DELIVERY_ADDRESS = TEST_ORDER.getDeliveryAddress();
    private static final UserDetail TEST_USER_DETAIL = TEST_ORDER.getUserDetail();
    private static final List<DishToOrder> TEST_DISHES_TO_ORDER = TEST_ORDER.getDishesToOrder();

    @Test
    public void testOrderCreation() throws Exception {
        OrderMobileV1Request request = getOrderMobileV1Request();

        doAnswer((invocation) -> TEST_ORDER.getEntity()).when(orderService).create(any(Order.class));

        OrderMobileV1Response expectedResponse = getExpectedOrderMobileV1Response();

        mockMvc.perform(post(OrderMobileV1Controller.API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJson(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(getJson(expectedResponse)));

        verify(orderService).create(any());
    }

    private OrderMobileV1Response getExpectedOrderMobileV1Response() {
        OrderMobileV1Response response = new OrderMobileV1Response();
        response.setId(TEST_ORDER.getId());
        response.setTotalPrice(TEST_ORDER.getTotalPrice());
        response.setOrderStatus(TEST_ORDER.getOrderStatus());
        response.setPaymentMethod(TEST_ORDER.getPaymentMethod());
        response.setDeliveryAddress(getExpectedDeliveryAddressMobileV1Response());
        response.setUserDetail(getExpectedUserDetailMobileV1Response());
        response.setDishesToOrder(getExpectedDishesToOrderMobileV1Responses());
        response.setCreatedDate(TEST_ORDER.getCreatedDate());
        response.setLastModifiedDate(TEST_ORDER.getLastModifiedDate());
        return response;
    }

    private DeliveryAddressMobileV1Response getExpectedDeliveryAddressMobileV1Response() {
        DeliveryAddressMobileV1Response response = new DeliveryAddressMobileV1Response();
        response.setId(TEST_DELIVERY_ADDRESS.getId());
        response.setCountry(TEST_DELIVERY_ADDRESS.getCountry());
        response.setCity(TEST_DELIVERY_ADDRESS.getCity());
        response.setStreet(TEST_DELIVERY_ADDRESS.getStreet());
        response.setHouseNumber(TEST_DELIVERY_ADDRESS.getHouseNumber());
        response.setAdditionalInfo(TEST_DELIVERY_ADDRESS.getAdditionalInfo());
        return response;
    }

    private UserDetailMobileV1Response getExpectedUserDetailMobileV1Response() {
        UserDetailMobileV1Response response = new UserDetailMobileV1Response();
        response.setId(TEST_USER_DETAIL.getId());
        response.setFirstName(TEST_USER_DETAIL.getFirstName());
        response.setLastName(TEST_USER_DETAIL.getLastName());
        response.setEmail(TEST_USER_DETAIL.getEmail());
        response.setPhoneNumber(TEST_USER_DETAIL.getPhoneNumber());
        response.setImageUrl(TEST_USER_DETAIL.getImageUrl());
        return response;
    }

    private List<DishToOrderMobileV1Response> getExpectedDishesToOrderMobileV1Responses() {
        return TEST_ORDER.getDishesToOrder().stream().map(dishToOrder -> {
            DishToOrderMobileV1Response dishToOrderMobileV1Response = new DishToOrderMobileV1Response();
            dishToOrderMobileV1Response.setId(dishToOrder.getId());
            dishToOrderMobileV1Response.setQuantity(dishToOrder.getQuantity());
            dishToOrderMobileV1Response.setDishName(dishToOrder.getDishName());
            dishToOrderMobileV1Response.setDishCategoryName(dishToOrder.getDishCategoryName());
            dishToOrderMobileV1Response.setCategoryId(dishToOrder.getCategoryId());
            dishToOrderMobileV1Response.setDishId(dishToOrder.getDishId());
            dishToOrderMobileV1Response.setCreatedDate(dishToOrder.getCreatedDate());
            dishToOrderMobileV1Response.setLastModifiedDate(dishToOrder.getLastModifiedDate());
            return dishToOrderMobileV1Response;
        }).toList();
    }

    private OrderMobileV1Request getOrderMobileV1Request() {
        OrderMobileV1Request request = new OrderMobileV1Request();
        request.setPaymentMethod(TEST_ORDER.getPaymentMethod());
        request.setUserDetail(getValidUserDetailMobileV1Request());
        request.setDeliveryAddress(getDeliveryAddressMobileV1Request());
        request.setDishes(getValidDishToOrderMobileV1Requests());
        return request;
    }

    private DeliveryAddressMobileV1Request getDeliveryAddressMobileV1Request() {
        DeliveryAddressMobileV1Request request = new DeliveryAddressMobileV1Request();
        request.setCountry(TEST_DELIVERY_ADDRESS.getCountry());
        request.setCity(TEST_DELIVERY_ADDRESS.getCity());
        request.setHouseNumber(TEST_DELIVERY_ADDRESS.getHouseNumber());
        request.setAdditionalInfo(TEST_DELIVERY_ADDRESS.getAdditionalInfo());
        return request;
    }

    private UserDetailMobileV1Request getValidUserDetailMobileV1Request() {
        UserDetailMobileV1Request request = new UserDetailMobileV1Request();
        request.setFirstName(TEST_USER_DETAIL.getFirstName());
        request.setLastName(TEST_USER_DETAIL.getLastName());
        request.setEmail(TEST_USER_DETAIL.getEmail());
        request.setPhoneNumber(TEST_USER_DETAIL.getPhoneNumber());
        request.setImageUrl(TEST_USER_DETAIL.getImageUrl());
        return request;
    }

    private List<DishToOrderMobileV1Request> getValidDishToOrderMobileV1Requests() {
        return TEST_DISHES_TO_ORDER.stream().map(dishToOrder -> {
            DishToOrderMobileV1Request request = new DishToOrderMobileV1Request();
            request.setDishId(dishToOrder.getDishId());
            request.setCategoryId(dishToOrder.getCategoryId());
            request.setQuantity(dishToOrder.getQuantity());
            request.setDishName(dishToOrder.getDishName());
            request.setDishCategoryName(dishToOrder.getDishCategoryName());
            return request;
        }).toList();
    }

    private String getJson(Object object) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(object, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
