package com.kot.user.api.backoffice.v1.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.kot.user.builder.UserEntityBuilder;
import com.kot.user.entity.UserEntity;
import com.kot.user.service.UserService;

@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
class UserV1ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	private UserV1ApiMapper userV1ApiMapper;

	@MockBean
	private UserService userService;

	private final UserEntityBuilder userEntityBuilder = new UserEntityBuilder();

	@Test
	public void testFindUserById() throws Exception {
		UserEntity user = userEntityBuilder.build();
		String userId = user.getId().toString();
		when(userService.findById(user.getId().toString())).thenReturn(user);

		UserV1Response expectedUser = userV1ApiMapper.domainToDto(user);
		expectedUser.setId(UUID.fromString(userId));

		mockMvc.perform(get(UserV1Controller.API_URL + "/{id}", expectedUser.getId())
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(getJson(expectedUser)));

		verify(userService).findById(userId);
	}

	@Test
	public void testNotFoundUserOnFindById() throws Exception {
		String userId = "random-id";
		when(userService.findById(any(String.class))).thenReturn(null);


		mockMvc.perform(get(UserV1Controller.API_URL + "/{id}", userId)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isNotFound());

		verify(userService).findById(userId);
	}

	@Test
	public void testGetAllUnpaged() throws Exception {
		List<UserEntity> userEntityList = Arrays.asList(
				userEntityBuilder.build(),
				userEntityBuilder.build(),
				userEntityBuilder.build()
		);
		Page<UserEntity> page = getPageMock();
		when(page.getContent()).thenReturn(userEntityList);
		when(userService.findAll()).thenReturn(page);

		List<UserV1Response> expectedUsers = userEntityList.stream().map(userV1ApiMapper::domainToDto).toList();

		mockMvc.perform(get(UserV1Controller.API_URL + "/unpaged")
						.accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(getJson(expectedUsers)));

		verify(userService).findAll();
	}

	@Test
	public void testGetAll() throws Exception {
		List<UserEntity> userEntityList = Arrays.asList(
				userEntityBuilder.build(),
				userEntityBuilder.build(),
				userEntityBuilder.build()
		);
		Page<UserEntity> page = new PageImpl<>(userEntityList);

		when(userService.findAll(any(Pageable.class))).thenReturn(page);

		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
		queryParams.add("pageIndex", "0");
		queryParams.add("pageSize", "10");
		queryParams.add("sortDirection", "ASC");
		queryParams.add("sortField", "username");

		mockMvc.perform(get(UserV1Controller.API_URL)
						.params(queryParams)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andExpect(content().json(getJson(page))) TODO
				.andReturn();

		verify(userService, times(1)).findAll(any(Pageable.class));
	}

	private String getJson(Object object) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(object, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}

	private Page<UserEntity> getPageMock() {
		return mock(Page.class);
	}

}
