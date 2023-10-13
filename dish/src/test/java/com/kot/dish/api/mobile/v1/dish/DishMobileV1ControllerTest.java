package com.kot.dish.api.mobile.v1.dish;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.kot.dish.builder.TestDishBuilder;
import com.kot.dish.domain.DishEntity;
import com.kot.dish.service.DishService;

@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
class DishMobileV1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @MockBean
    private DishService dishService;

    @Autowired
    private DishMobileV1ApiMapper dishMobileV1ApiMapper;

    private final TestDishBuilder testDishBuilder = new TestDishBuilder();

    @Test
    public void testFindDishById() throws Exception {
        DishEntity dish = testDishBuilder.build();
        when(dishService.findById(dish.getId())).thenReturn(dish);

        DishMobileV1Response expectedDish = dishMobileV1ApiMapper.domainToDto(dish);
        expectedDish.setId(dish.getId());

        mockMvc.perform(get(DishMobileV1Controller.API_URL + "/{id}", expectedDish.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(getJson(expectedDish)));

        verify(dishService).findById(dish.getId());
    }

    @Test
    public void testNotFoundUserOnFindById() throws Exception {
        Long dishId = 23242342342342L;
        when(dishService.findById(any(Long.class))).thenReturn(null);

        mockMvc.perform(get(DishMobileV1Controller.API_URL + "/{id}", dishId.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(dishService).findById(dishId);
    }

    @Test
    public void testGetAll() throws Exception {
        List<DishEntity> dishEntityList = Arrays.asList(
                testDishBuilder.build(),
                testDishBuilder.build(),
                testDishBuilder.build()
        );
        Page<DishEntity> page = new PageImpl<>(dishEntityList);

        when(dishService.findAll()).thenReturn(page);

        List<DishMobileV1Response> expected = dishEntityList.stream().map(dishMobileV1ApiMapper::domainToDto).toList();

        mockMvc.perform(get(DishMobileV1Controller.API_URL + "/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(getJson(expected)))
                .andReturn();

        verify(dishService, times(1)).findAll();
    }

    private String getJson(Object object) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(object, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
