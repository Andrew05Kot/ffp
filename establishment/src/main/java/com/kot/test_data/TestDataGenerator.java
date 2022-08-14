package com.kot.test_data;

import java.security.SecureRandom;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.kot.repository.EstablishmentRepository;

@Component
@Profile("testdata")
public class TestDataGenerator {

	private static final List<String> CITIES = List.of("Chernivtsi", "Ivano-Frankivsk", "Lviv", "Kolomyia", "Kyiv", "Lutsk", "Uzgorod", "Ternopil", "Khmelnytskyi", "Cherkasy", "Rivne", "Zitomyr", "Vinnytsia ", "Odessa", "Kherson");

	private final EstablishmentBuilder establishmentBuilder = new EstablishmentBuilder();

	private final SecureRandom random = new SecureRandom();

	@Autowired
	private EstablishmentRepository establishmentRepository;

	@PostConstruct
	void initTestData() {
		int randomCount = random.nextInt(140) + 200;
		for (int i = 0; i < randomCount; i++) {
			establishmentRepository.save(establishmentBuilder
					.setCountry("Ukraine")
					.setCity(CITIES.get(random.nextInt(CITIES.size())))
					.buildNewEntity());
		}
	}
}
