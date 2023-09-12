package com.kot.ordering.api.backoffice.v1;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.UUID;
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

import com.kot.ordering.api.mobile.v1.delevery_address.DeliveryAddressMobileV1Response;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Response;
import com.kot.ordering.builder.TestOrderBuilder;
import com.kot.ordering.model.DeliveryAddress;
import com.kot.ordering.model.Order;
import com.kot.ordering.model.UserDetail;
import com.kot.ordering.service.order.OrderService;

@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
class OrderV1ControllerTest {

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
    public void testFindOrderById() throws Exception {
        Order order = TEST_ORDER;
        UUID orderId = order.getId();
        when(orderService.findById(order.getId())).thenReturn(order);

        OrderMobileV1Response expectedOrder = getExpectedV1Response();
        expectedOrder.setId(orderId);

        mockMvc.perform(get(OrderV1Controller.API_URL + "/{id}", expectedOrder.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(getJson(expectedOrder)));

        verify(orderService).findById(orderId);
    }

    @Test
    public void testNotFoundOrderOnFindById() throws Exception {
        UUID orderId = UUID.randomUUID();
        when(orderService.findById(any(UUID.class))).thenReturn(null);

        mockMvc.perform(get(OrderV1Controller.API_URL + "/{id}", orderId)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(orderService).findById(orderId);
    }

    private OrderMobileV1Response getExpectedV1Response() {
        OrderMobileV1Response response = new OrderMobileV1Response();
        response.setTotalPrice(TEST_ORDER.getTotalPrice());
        response.setCardName(TEST_ORDER.getCardName());
        response.setCardNumber(TEST_ORDER.getCardNumber());
        response.setExpiration(TEST_ORDER.getExpiration());
        response.setCvv(TEST_ORDER.getCvv());
        response.setPaymentMethod(TEST_ORDER.getPaymentMethod());
        response.setDeliveryAddress(getExpectedDeliveryAddressV1Response());
        response.setUserDetail(getExpectedUserDetailV1Response());
        return response;
    }

    private DeliveryAddressMobileV1Response getExpectedDeliveryAddressV1Response() {
        DeliveryAddressMobileV1Response response = new DeliveryAddressMobileV1Response();
        response.setCountry(TEST_DELIVERY_ADDRESS.getCountry());
        response.setCity(TEST_DELIVERY_ADDRESS.getCity());
        response.setStreet(TEST_DELIVERY_ADDRESS.getStreet());
        response.setHouseNumber(TEST_DELIVERY_ADDRESS.getHouseNumber());
        response.setAdditionalInfo(TEST_DELIVERY_ADDRESS.getAdditionalInfo());
        return response;
    }

    private UserDetailMobileV1Response getExpectedUserDetailV1Response() {
        UserDetailMobileV1Response response = new UserDetailMobileV1Response();
        response.setFirstName(TEST_USER_DETAIL.getFirstName());
        response.setLastName(TEST_USER_DETAIL.getLastName());
        response.setEmail(TEST_USER_DETAIL.getEmail());
        response.setPhoneNumber(TEST_USER_DETAIL.getPhoneNumber());
        response.setImageUrl(TEST_USER_DETAIL.getImageUrl());
        return response;
    }

    private String getJson(Object object) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(object, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
