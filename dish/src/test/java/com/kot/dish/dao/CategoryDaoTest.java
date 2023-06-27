package com.kot.dish.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.kot.dish.domain.CategoryEntity;
import com.kot.dish.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryDaoTest {

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryDao categoryDao;

	private CategoryEntity categoryEntity;

	@BeforeEach
	public void setup() {
		categoryEntity = new CategoryEntity();
		categoryEntity.setId(1L);
		categoryEntity.setName("TestCategory");
		categoryEntity.setDescription("Test Description");
		categoryEntity.setIconName("test-icon");
	}

	@Test
	public void testSaveCategory() {
		when(categoryRepository.save(any(CategoryEntity.class))).thenReturn(categoryEntity);

		CategoryEntity savedCategory = categoryDao.save(categoryEntity, 1L);

		assertEquals(categoryEntity, savedCategory);
	}

	@Test
	public void testFindById() {
		when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(categoryEntity));

		CategoryEntity foundCategory = categoryDao.findById(1L);

		assertEquals(categoryEntity, foundCategory);
	}

	@Test
	public void testFindAll() {
		List<CategoryEntity> categoryList = new ArrayList<>();
		categoryList.add(categoryEntity);
		Page<CategoryEntity> categoryPage = new PageImpl<>(categoryList);

		when(categoryRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(categoryPage);

		Page<CategoryEntity> foundCategories = categoryDao.findAll();

		assertEquals(categoryPage, foundCategories);
	}
}
