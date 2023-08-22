package com.kot.dish.api.backoffice.v1.ingredient;

import java.util.List;
import java.util.Optional;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kot.dish.api.ApiInfo;
import com.kot.dish.api.backoffice.v1.infrastructure.ApiV1Mapper;
import com.kot.dish.api.backoffice.v1.infrastructure.PageV1Response;
import com.kot.dish.domain.IngredientEntity;
import com.kot.dish.service.IngredientService;

@RestController
@RequestMapping(IngredientV1Controller.API_URL)
@Tag(name = "Ingredient Backoffice API V1")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8765"})
public class IngredientV1Controller {

	static final int DEFAULT_PAGE_SIZE = 15;
	public static final int DEFAULT_PAGE_INDEX = 0;
	public static final String DEFAULT_SORT_DIRECTION = "ASC";
	public static final String DEFAULT_SORT_FIELD = "id";
	public static final Sort DEFAULT_SORT = Sort.by(Sort.Order.by(DEFAULT_SORT_DIRECTION).withProperty(DEFAULT_SORT_FIELD));

	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.API_VERSION_V1 + ApiInfo.INGREDIENT_ENDPOINT;

	@Autowired
	private IngredientService ingredientService;

	@Autowired
	private ApiV1Mapper<IngredientEntity, IngredientV1Response, IngredientV1Response> ingredientV1Mapper;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus() {
		return new ResponseEntity<>("Works!", HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public PageV1Response<IngredientV1Response> getAll(
			@RequestParam(name = "pageIndex") Optional<Integer> pageIndex,
			@RequestParam(name = "pageSize") Optional<Integer> pageSize,
			@RequestParam(name = "sortDirection") Optional<String> sortDirection,
			@RequestParam(name = "sortField") Optional<String> sortField,
			@RequestParam(value = "search", required = false) Optional<String> search) {
		Sort sort = getSort(sortDirection, sortField);
		Pageable pageable = getResult(pageIndex, pageSize, sort);

		Page<IngredientEntity> fetchedPage = search.isPresent() ? ingredientService.findAll(search.get(), pageable) : ingredientService.findAll(pageable);

		return new PageV1Response<>(fetchedPage.stream().map(entity -> ingredientV1Mapper.domainToDto(entity)).toList(),
				fetchedPage.getTotalElements(),
				pageable.getPageNumber(),
				pageable.getPageSize());
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/unpaged")
	public List<IngredientV1Response> getAll() {
		Page<IngredientEntity> fetchedPage = ingredientService.findAll();
		return fetchedPage.getContent().stream().map(ingredientV1Mapper::domainToDto).toList();
	}

	private static Pageable getResult(Optional<Integer> pageIndex, Optional<Integer> pageSize, Sort sort) {
		int size = pageSize.orElse(DEFAULT_PAGE_SIZE);
		int index = pageIndex.orElse(DEFAULT_PAGE_INDEX);
		return PageRequest.of(index, size, sort);
	}

	private Sort getSort(Optional<String> sortDirection, Optional<String> sortField) {
		if (sortField.isPresent() && sortDirection.isPresent()) {
			return switch (sortDirection.get().toUpperCase()) {
				case "ASC" -> Sort.by(Sort.Order.asc(sortField.get()));
				case "DESC" -> Sort.by(Sort.Order.desc(sortField.get()));
				default -> DEFAULT_SORT;
			};
		}
		return DEFAULT_SORT;
	}
}
