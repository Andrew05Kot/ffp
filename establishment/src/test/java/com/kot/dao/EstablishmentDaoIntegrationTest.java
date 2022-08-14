package com.kot.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.PredicateTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import com.kot.api.predicates.EstablishmentPredicatesBuilder;
import com.kot.entity.EstablishmentEntity;
import com.kot.test_data.EstablishmentBuilder;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
@SpringBootTest
class EstablishmentDaoIntegrationTest {

	@Autowired
	private EstablishmentDao establishmentDao;

	private final EstablishmentBuilder establishmentBuilder = new EstablishmentBuilder();

	@Test
	void filteringTest() {
		List<EstablishmentEntity> establishmentsList = List.of(
				establishmentBuilder.setCountry("specialCountry").buildNewEntity(),
				establishmentBuilder.setCountry("specialCountry").buildNewEntity(),
				establishmentBuilder.buildNewEntity());

		establishmentsList = establishmentsList.stream().map(establishment -> establishmentDao.save(establishment)).collect(Collectors.toList());
		EstablishmentPredicatesBuilder establishmentPredicatesBuilder = new EstablishmentPredicatesBuilder()
				.with("country", "=", "specialCountry");

		Page<EstablishmentEntity> result = establishmentDao.findAll(establishmentPredicatesBuilder.build());

		assertEquals(2, result.getContent().size());
	}

}