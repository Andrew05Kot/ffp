package com.kot.ordering.api.mobile.v1.order;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
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
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Request;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Response;
import com.kot.ordering.builder.TestOrderBuilder;
import com.kot.ordering.model.DeliveryAddress;
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

    @Test
    public void testOrderCreation() throws Exception {
        OrderMobileV1Request request = getOrderMobileV1Request();

        doAnswer((invocation) -> TEST_ORDER.getEntity()).when(orderService).create(any(Order.class));

        mockMvc.perform(post(OrderMobileV1Controller.API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJson(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(getJson(getExpectedOrderMobileV1Response())));

        verify(orderService).create(any());
    }

    private OrderMobileV1Response getExpectedOrderMobileV1Response() {
        OrderMobileV1Response response = new OrderMobileV1Response();
        response.setId(TEST_ORDER.getId());
        response.setTotalPrice(TEST_ORDER.getTotalPrice());
        response.setCardName(TEST_ORDER.getCardName());
        response.setCardNumber(TEST_ORDER.getCardNumber());
        response.setExpiration(TEST_ORDER.getExpiration());
        response.setCvv(TEST_ORDER.getCvv());
        response.setPaymentMethod(TEST_ORDER.getPaymentMethod());
        response.setDeliveryAddress(getExpectedDeliveryAddressMobileV1Response());
        response.setUserDetail(getExpectedUserDetailMobileV1Response());
        return response;
    }

    private DeliveryAddressMobileV1Response getExpectedDeliveryAddressMobileV1Response() {
        DeliveryAddressMobileV1Response response = new DeliveryAddressMobileV1Response();
        response.setCountry(TEST_DELIVERY_ADDRESS.getCountry());
        response.setCity(TEST_DELIVERY_ADDRESS.getCity());
        response.setStreet(TEST_DELIVERY_ADDRESS.getStreet());
        response.setHouseNumber(TEST_DELIVERY_ADDRESS.getHouseNumber());
        response.setAdditionalInfo(TEST_DELIVERY_ADDRESS.getAdditionalInfo());
        return response;
    }

    private UserDetailMobileV1Response getExpectedUserDetailMobileV1Response() {
        UserDetailMobileV1Response response = new UserDetailMobileV1Response();
        response.setFirstName(TEST_USER_DETAIL.getFirstName());
        response.setLastName(TEST_USER_DETAIL.getLastName());
        response.setEmail(TEST_USER_DETAIL.getEmail());
        response.setPhoneNumber(TEST_USER_DETAIL.getPhoneNumber());
        response.setImageUrl(TEST_USER_DETAIL.getImageUrl());
        return response;
    }

    private OrderMobileV1Request getOrderMobileV1Request() {
        OrderMobileV1Request request = new OrderMobileV1Request();
        request.setCardName(TEST_ORDER.getCardName());
        request.setCardNumber(TEST_ORDER.getCardNumber());
        request.setExpiration(TEST_ORDER.getExpiration());
        request.setCvv(TEST_ORDER.getCvv());
        request.setPaymentMethod(TEST_ORDER.getPaymentMethod());
        request.setUserDetail(getValidUserDetailMobileV1Request());
        request.setDeliveryAddress(getDeliveryAddressMobileV1Request());
        request.setUserId("1L");
        request.setDishIds(TEST_ORDER.getSelectedDishes());
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

    private String getJson(Object object) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(object, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
