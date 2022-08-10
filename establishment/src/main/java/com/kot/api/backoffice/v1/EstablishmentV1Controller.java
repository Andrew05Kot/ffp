package com.kot.api.backoffice.v1;

import javax.validation.groups.Default;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.kot.api.ApiInfo;
import com.kot.entity.EstablishmentEntity;
import com.kot.service.EstablishmentService;

@RestController
@RequestMapping(EstablishmentV1Controller.API_URL)
@Tag(name = "Ordering API")
public class EstablishmentV1Controller {

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

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public void deleteById(@PathVariable(value = "id") Long id) {
        establishmentService.delete(id);
    }

}
