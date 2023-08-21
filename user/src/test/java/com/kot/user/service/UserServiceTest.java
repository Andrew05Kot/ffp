package com.kot.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.kot.user.dao.UserDao;
import com.kot.user.entity.UserEntity;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserDao userDao;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreate() {
		UserEntity user = new UserEntity();
		when(userDao.create(user)).thenReturn(user);

		UserEntity createdUser = userService.create(user);
		assertEquals(user, createdUser);
	}

	@Test
	public void testUpdate() {
		UserEntity user = new UserEntity();
		String userId = "123";
		when(userDao.update(user, userId)).thenReturn(user);

		UserEntity updatedUser = userService.update(user, userId);
		assertEquals(user, updatedUser);
	}

	@Test
	public void testFindById() {
		String userId = "123";
		UserEntity user = new UserEntity();
		when(userDao.findById(userId)).thenReturn(user);

		UserEntity foundUser = userService.findById(userId);
		assertEquals(user, foundUser);
	}

	@Test
	public void testFindAllDefault() {
		Page<UserEntity> mockPage = mock(Page.class);
		when(userDao.findAll(any(Specification.class), any(Pageable.class))).thenReturn(mockPage);

		Page<UserEntity> resultPage = userService.findAll();
		assertEquals(mockPage, resultPage);
	}

	@Test
	public void testFindAllWithFilterAndPageable() {
		Specification<UserEntity> filter = mock(Specification.class);
		Pageable pageable = mock(Pageable.class);
		Page<UserEntity> mockPage = mock(Page.class);
		when(userDao.findAll(filter, pageable)).thenReturn(mockPage);

		Page<UserEntity> resultPage = userService.findAll(filter, pageable);
		assertEquals(mockPage, resultPage);
	}

	@Test
	public void testFindAllWithSpecification() {
		Specification<UserEntity> specification = mock(Specification.class);
		List<UserEntity> mockUsers = new ArrayList<>();
		when(userDao.findAll(specification)).thenReturn(mockUsers);

		List<UserEntity> resultUsers = userService.findAll(specification);
		assertEquals(mockUsers, resultUsers);
	}

	@Test
	public void testFindAllPageable() {
		Pageable pageable = mock(Pageable.class);
		Page<UserEntity> mockPage = mock(Page.class);
		when(userDao.findAll(pageable)).thenReturn(mockPage);

		Page<UserEntity> resultPage = userService.findAll(pageable);
		assertEquals(mockPage, resultPage);
	}
}