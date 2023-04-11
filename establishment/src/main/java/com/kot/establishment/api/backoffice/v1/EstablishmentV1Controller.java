package com.kot.establishment.api.backoffice.v1;

import com.kot.establishment.api.ApiInfo;
import com.kot.establishment.entity.EstablishmentEntity;
import com.kot.establishment.service.EstablishmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.Optional;

@RestController
@RequestMapping(EstablishmentV1Controller.API_URL)
@Tag(name = "Establishment Backoffice API V1")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8765"})
public class EstablishmentV1Controller {

    public static int DEFAULT_PAGE_SIZE = 15;
    public static int DEFAULT_PAGE_INDEX = 0;

    @Autowired
    private EstablishmentService establishmentService;

    public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.API_VERSION_V1 + ApiInfo.ESTABLISHMENT_ENDPOINT;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EstablishmentV1Response create(@Validated(Default.class) @RequestBody EstablishmentV1Request request) {
        EstablishmentEntity establishmentEntity = establishmentService.create(request.toEntityForCreate(null));
        return new EstablishmentV1Response(establishmentService.create(establishmentEntity));
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EstablishmentV1Response update(@PathVariable(value = "id") Long id,
                                          @Validated(Default.class) @RequestBody EstablishmentV1Request request) {
        EstablishmentEntity establishmentEntity = establishmentService.update(request.toEntityForCreate(id));
        return new EstablishmentV1Response(establishmentService.create(establishmentEntity));
    }

    @GetMapping(path = "{id}")
    @ResponseBody
    public EstablishmentV1Response getById(@PathVariable(value = "id") Long id) {
        return new EstablishmentV1Response(establishmentService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public EstablishmentPageV1Response getAll(
            @RequestParam(required = false) Optional<Integer> pageIndex
            , @RequestParam(required = false) Optional<Integer> pageSize
            , @RequestParam(required = false) Sort sort
    ) {
        int size = pageSize.orElse(DEFAULT_PAGE_SIZE);
        int index = pageIndex.orElse(DEFAULT_PAGE_INDEX);
        boolean isPageable = pageIndex.isPresent() && size > 0;

        Pageable pageable = isPageable ?
                PageRequest.of(index, size, Sort.by(Sort.Order.asc("id")))
                : Pageable.unpaged();

        Page<EstablishmentEntity> fetchedPage = establishmentService.findAll(pageable);
        return new EstablishmentPageV1Response(fetchedPage.stream().map(EstablishmentV1Response::new).toList(),
                fetchedPage.getTotalElements(),
                index,
                size);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public void deleteById(@PathVariable(value = "id") Long id) {
        establishmentService.delete(id);
    }

}
