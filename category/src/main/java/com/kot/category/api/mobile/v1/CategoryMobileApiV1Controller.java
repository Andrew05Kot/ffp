package com.kot.category.api.mobile.v1;

import java.util.List;
import java.util.stream.Collectors;
import com.kot.category.api.ApiInfo;
import com.kot.category.bll.model.Category;
import com.kot.category.bll.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CategoryMobileApiV1Controller.API_URL)
@Tag(name = "Category Mobile API")
public class CategoryMobileApiV1Controller {

	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.MOBILE_API_VERSION_V1 + ApiInfo.CATEGORY_ENDPOINT;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryMobileApiV1Mapper categoryApiMapper;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus() {
		return new ResponseEntity<>("Works!", HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<CategoryMobileApiV1Response> create(@RequestBody CategoryMobileApiV1Request request) {
		Category model = categoryService.save(categoryApiMapper.dtoToModel(request));
		return new ResponseEntity<>(categoryApiMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryMobileApiV1Response> getById(@PathVariable Long id) {
		Category model = categoryService.findById(id);
		return new ResponseEntity<>(categoryApiMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryMobileApiV1Response>> getAll() {
		List<Category> dishEntities = categoryService.findAll().getContent();
		List<CategoryMobileApiV1Response> dishResponses = dishEntities
				.stream()
				.map(model -> categoryApiMapper.modelToDto(model))
				.collect(Collectors.toList());
		return new ResponseEntity<>(dishResponses, HttpStatus.OK);
	}
}
