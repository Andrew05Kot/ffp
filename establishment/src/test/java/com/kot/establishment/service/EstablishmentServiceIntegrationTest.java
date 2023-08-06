package com.kot.establishment.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.kot.establishment.entity.EstablishmentEntity;
import com.kot.establishment.test_data.EstablishmentBuilder;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
@SpringBootTest
class EstablishmentServiceIntegrationTest {

	@Autowired
	private EstablishmentService establishmentService;


	private final EstablishmentBuilder establishmentBuilder = new EstablishmentBuilder();

	@Test
	void saveItemTest() {
		EstablishmentEntity establishmentEntity = establishmentBuilder.buildNewEntity();
		EstablishmentEntity savedEntity = establishmentService.create(establishmentEntity);

		assertNotNull(savedEntity.getId());
	}

	@Test
	void deleteItemTest() {
		EstablishmentEntity establishmentEntity = establishmentService.create(establishmentBuilder.buildNewEntity());
		establishmentService.delete(establishmentEntity.getId());

		Assertions.assertThrows(EntityNotFoundException.class, () -> {
			establishmentService.findById(establishmentEntity.getId());
		});
	}

	@Test
	void findAllTest() {
		List<EstablishmentEntity> establishmentsList = List.of(
				establishmentBuilder.setCountry("specialCountry").buildNewEntity(),
				establishmentBuilder.setCountry("specialCountry").buildNewEntity(),
				establishmentBuilder.setCountry("Chenivtsi").buildNewEntity(),
				establishmentBuilder.buildNewEntity());

		List<EstablishmentEntity> savedEntries = establishmentsList.stream().map(establishment -> establishmentService.create(establishment)).toList();
		List<EstablishmentEntity> fetchedEntries = establishmentService.findAll().getContent();

		assertEquals(savedEntries.size(), fetchedEntries.size());
	}

	@Test
	void filteringByCountryNameTest() {

		List<EstablishmentEntity> establishmentsList = List.of(
				establishmentBuilder.setCountry("specialCountry").buildNewEntity(),
				establishmentBuilder.setCountry("specialCountry").buildNewEntity(),
				establishmentBuilder.setCountry("Chenivtsi").buildNewEntity(),
				establishmentBuilder.buildNewEntity());

		List<EstablishmentEntity> savedEntries = establishmentsList.stream().map(establishment -> establishmentService.create(establishment)).toList();

		String search = "country:Chenivtsi";

		List<EstablishmentEntity> fetchedEntries = establishmentService.findAll(search, Pageable.unpaged()).getContent();

		assertEquals(1, fetchedEntries.size());
	}

	@Test
	void filteringByCoordinatesTest() {

		List<EstablishmentEntity> establishmentsList = List.of(
				establishmentBuilder.setLongitude(10.0).setLatitude(20.0).buildNewEntity(),
				establishmentBuilder.setLongitude(12.0).setLatitude(20.0).buildNewEntity(),
				establishmentBuilder.setLongitude(13.0).setLatitude(20.0).buildNewEntity(),
				establishmentBuilder.setLongitude(14.0).setLatitude(20.0).buildNewEntity(),
				establishmentBuilder.setLongitude(15.0).setLatitude(20.0).buildNewEntity()
		);

		establishmentsList.forEach(establishment -> establishmentService.create(establishment));

		String search = "longitude>=13.0";
		List<EstablishmentEntity> fetchedEntries = establishmentService.findAll(search, Pageable.unpaged()).getContent();
		assertEquals(3, fetchedEntries.size());

		search = "longitude<=12.0";
		fetchedEntries = establishmentService.findAll(search, Pageable.unpaged()).getContent();
		assertEquals(2, fetchedEntries.size());
	}

}