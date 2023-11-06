package com.kot.user.api.backoffice.v1.user;

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
import org.springframework.web.bind.annotation.*;

import com.kot.user.api.ApiInfo;
import com.kot.user.api.backoffice.v1.PageV1Response;
import com.kot.user.entity.UserEntity;
import com.kot.user.service.UserService;

@RestController
@RequestMapping(UserV1Controller.API_URL)
@Tag(name = "User Backoffice API V1")
public class UserV1Controller {

	static final int DEFAULT_PAGE_SIZE = 15;
	public static final int DEFAULT_PAGE_INDEX = 0;
	public static final String DEFAULT_SORT_DIRECTION = "ASC";
	public static final String DEFAULT_SORT_FIELD = "id";
	public static final Sort DEFAULT_SORT = Sort.by(Sort.Order.by(DEFAULT_SORT_DIRECTION).withProperty(DEFAULT_SORT_FIELD));
	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.API_VERSION_V1 + ApiInfo.USER_ENDPOINT;

	@Autowired
	private UserService userService;

	@Autowired
	private UserV1ApiMapper userV1ApiMapper;

	@PostMapping(path = "/registration")
	public ResponseEntity<UserV1Response> create(@RequestBody UserV1Request request) {
		UserEntity entity = userService.create(userV1ApiMapper.dtoToDomain(request));
		return new ResponseEntity<>(userV1ApiMapper.domainToDto(entity), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserV1Response> getById(@PathVariable String id) {
		UserEntity entity = userService.findById(id);
		if (entity != null) {
			return new ResponseEntity<>(userV1ApiMapper.domainToDto(entity), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public PageV1Response<UserV1Response> getAll(
			@RequestParam(name = "pageIndex") Optional<Integer> pageIndex,
			@RequestParam(name = "pageSize") Optional<Integer> pageSize,
			@RequestParam(name = "sortDirection") Optional<String> sortDirection,
			@RequestParam(name = "sortField") Optional<String> sortField,
			@RequestParam(value = "search", required = false) Optional<String> search) {
		Sort sort = getSort(sortDirection, sortField);
		Pageable pageable = getResult(pageIndex, pageSize, sort);

		Page<UserEntity> fetchedPage = search.isPresent() ? userService.findAll(search.get(), pageable) : userService.findAll(pageable);

		return new PageV1Response<>(fetchedPage.stream().map(userV1ApiMapper::domainToDto).toList(),
				fetchedPage.getTotalElements(),
				pageable.getPageNumber(),
				pageable.getPageSize());
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/unpaged")
	public List<UserV1Response> getAll() {
		Page<UserEntity> fetchedPage = userService.findAll();
		return fetchedPage.getContent().stream().map(userV1ApiMapper::domainToDto).toList();
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
