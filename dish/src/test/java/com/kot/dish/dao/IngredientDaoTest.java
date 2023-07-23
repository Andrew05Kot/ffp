//package com.kot.dish.dao;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.domain.Specification;
//
//import com.kot.dish.domain.IngredientEntity;
//import com.kot.dish.filtering.criteria_parser.FilteringCriteria;
//import com.kot.dish.filtering.criteria_parser.FilteringOperation;
//import com.kot.dish.filtering.models.ingredient.IngredientSpecificationsBuilder;
//import com.kot.dish.repository.IngredientRepository;
//
//@ExtendWith(MockitoExtension.class)
//public class IngredientDaoTest {
//
//	@Mock
//	private IngredientRepository ingredientRepository;
//
//	@InjectMocks
//	private IngredientDao ingredientDao;
//
//	private IngredientEntity savedEntity;
//
//	private final IngredientSpecificationsBuilder ingredientSpecificationsBuilder = new IngredientSpecificationsBuilder();
//
//	@BeforeEach
//	public void setup() {
//		getSavedSingleEntity();
//	}
//
//	private void getSavedSingleEntity() {
//		savedEntity = new IngredientEntity();
//		savedEntity.setId(1L);
//		savedEntity.setName("TestIngredient");
//		savedEntity.setDescription("Test Description");
//		savedEntity.setCalories(100.0);
//		savedEntity.setSugarPer100Gram(5.0);
//		savedEntity.setProteinPer100Gram(10.0);
//		savedEntity.setFatsPer100Gram(15.0);
//		savedEntity.setCarbohydratesPer100Gram(20.0);
//		savedEntity.setCarbonDioxidePer100Gram(2.0);
//	}
//
//	@Test
//	public void testFindAll() {
//		List<IngredientEntity> ingredientList = new ArrayList<>();
//		ingredientList.add(savedEntity);
//		Page<IngredientEntity> ingredientPage = new PageImpl<>(ingredientList);
//
//		when(ingredientRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(ingredientPage);
//
//		Page<IngredientEntity> foundIngredients = ingredientDao.findAll();
//
//		assertEquals(ingredientPage, foundIngredients);
//	}
//
//	@Test
//	public void testFindAllWithSpecification() {
//		List<IngredientEntity> ingredientList = new ArrayList<>();
//		ingredientList.add(savedEntity);
//
//		when(ingredientRepository.findAll(any(Specification.class))).thenReturn(ingredientList);
//
//		Specification<IngredientEntity> specification = getSpecification();
//		List<IngredientEntity> foundIngredients = ingredientDao.findAll(specification);
//
//		assertEquals(ingredientList, foundIngredients);
//	}
//
//	@Test
//	public void testFindAllWithPageable() {
//		List<IngredientEntity> ingredientList = new ArrayList<>();
//		ingredientList.add(savedEntity);
//		Page<IngredientEntity> ingredientPage = new PageImpl<>(ingredientList);
//		Pageable pageable = Mockito.mock(Pageable.class);
//		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("name"));
//
//		when(ingredientRepository.findAll(getSpecification(), pageRequest)).thenReturn(ingredientPage);
//
//		Page<IngredientEntity> foundIngredients = ingredientDao.findAll(pageable);
//
//		assertEquals(ingredientPage, foundIngredients);
//	}
//
//	private Specification<IngredientEntity> getSpecification() {
//		List<FilteringCriteria> filteringCriteria = new ArrayList<>();
//		filteringCriteria.add(new FilteringCriteria("name", FilteringOperation.CONTAIN, "wws"));
//		return ingredientSpecificationsBuilder.buildSpecification(filteringCriteria);
//	}
//
//
//}
