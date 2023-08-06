package com.kot.establishment.test_data;

import java.security.SecureRandom;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.kot.establishment.repository.EstablishmentRepository;

@Component
@Profile("!test")
public class TestDataGenerator {

	private static final List<String> CITIES = List.of("Chernivtsi", "Ivano-Frankivsk", "Lviv", "Kolomyia", "Kyiv", "Lutsk", "Uzgorod", "Ternopil", "Khmelnytskyi", "Cherkasy", "Rivne", "Zitomyr", "Vinnytsia ", "Odessa", "Kherson");

	private final EstablishmentBuilder establishmentBuilder = new EstablishmentBuilder();

	private final SecureRandom random = new SecureRandom();

	@Autowired
	private EstablishmentRepository establishmentRepository;

//    @PostConstruct
//    void initRandomDemoData() {
//        int randomCount = random.nextInt(140) + 200;
//        for (int i = 0; i < randomCount; i++) {
//            establishmentRepository.save(establishmentBuilder
//                    .setCountry("Ukraine")
//                    .setCity(CITIES.get(random.nextInt(CITIES.size())))
//                    .buildNewEntity());
//        }
//    }

	@PostConstruct
	void initRealDemoData() {
		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kyiv")
				.setStreet("Melnykova")
				.setHouseNumber("3")
				.setLatitude(50.450138)
				.setLongitude(30.523402)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kyiv")
				.setStreet("Sevastopolska")
				.setHouseNumber("1")
				.setLatitude(50.450608)
				.setLongitude(30.517826)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kharkiv")
				.setStreet("Pavlivska")
				.setHouseNumber("6")
				.setLatitude(50.033333)
				.setLongitude(36.25)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kyiv")
				.setStreet("Khreshchatyk")
				.setHouseNumber("19a")
				.setLatitude(50.450213)
				.setLongitude(30.522222)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kyiv")
				.setStreet("Borychiv")
				.setHouseNumber("10a")
				.setLatitude(50.452778)
				.setLongitude(30.516667)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kyiv")
				.setStreet("Yevhena Sverstiuka")
				.setHouseNumber("1")
				.setLatitude(50.45065)
				.setLongitude(30.52323)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kyiv")
				.setStreet("Teodora Draizera")
				.setHouseNumber("4")
				.setLatitude(50.45172)
				.setLongitude(30.52534)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Dnipro")
				.setStreet("Staromostova")
				.setHouseNumber("5")
				.setLatitude(48.43006)
				.setLongitude(35.04521)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kharkiv")
				.setStreet("Suzdalski Riady")
				.setHouseNumber("9")
				.setLatitude(50.02307)
				.setLongitude(36.25338)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kyiv")
				.setStreet("Borshchahivska")
				.setHouseNumber("2b")
				.setLatitude(50.45069)
				.setLongitude(30.52192)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Dnipro")
				.setStreet("Yuriia Kondratiuka")
				.setHouseNumber("2b")
				.setLatitude(48.43131)
				.setLongitude(35.04587)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Dnipro")
				.setStreet("Heroiv ave")
				.setHouseNumber("1v")
				.setLatitude(48.43053)
				.setLongitude(35.04544)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Odesa")
				.setStreet("Dobrovolskoho ave")
				.setHouseNumber("116")
				.setLatitude(46.44769)
				.setLongitude(30.73246)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Cherkasy")
				.setStreet("Smilianska")
				.setHouseNumber("31")
				.setLatitude(49.36645)
				.setLongitude(32.06533)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Donetsk")
				.setStreet("Komunariv")
				.setHouseNumber("1a")
				.setLatitude(48.02571)
				.setLongitude(37.81143)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Chernihiv")
				.setStreet("Kyrponosa")
				.setHouseNumber("34")
				.setLatitude(51.27222)
				.setLongitude(31.23333)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kyiv")
				.setStreet("Yuriia Haharina")
				.setHouseNumber("2a")
				.setLatitude(50.45011)
				.setLongitude(30.52344)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Sumy")
				.setStreet("Pokrovska")
				.setHouseNumber("15a")
				.setLatitude(50.83145)
				.setLongitude(34.77857)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Lviv")
				.setStreet("Tarasa Shevchenka ave")
				.setHouseNumber("7")
				.setLatitude(49.842957)
				.setLongitude(24.031111)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Zaporizhzhia")
				.setStreet("Sobornyi ave")
				.setHouseNumber("1999")
				.setLatitude(47.85575)
				.setLongitude(35.12533)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kryvyi Rih")
				.setStreet("Haharina ave.")
				.setHouseNumber("2")
				.setLatitude(47.87193)
				.setLongitude(33.24150)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Mykolaiv")
				.setStreet("Admirala Makarova")
				.setHouseNumber("43")
				.setLatitude(46.97247)
				.setLongitude(32.02873)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Simferopol")
				.setStreet("Haharina")
				.setHouseNumber("6")
				.setLatitude(44.957813)
				.setLongitude(34.109547)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Lviv")
				.setStreet("Viacheslava Chornovola ave")
				.setHouseNumber("12")
				.setLatitude(49.84218)
				.setLongitude(24.02905)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Vinnytsia")
				.setStreet("Soborna")
				.setHouseNumber("51a")
				.setLatitude(49.27893)
				.setLongitude(28.46478)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kharkiv")
				.setStreet("Poltavskyi Shliakh")
				.setHouseNumber("58/1")
				.setLatitude(50.01686)
				.setLongitude(36.25289)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Lviv")
				.setStreet("Svobody ave")
				.setHouseNumber("35")
				.setLatitude(49.84201)
				.setLongitude(24.03042)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kremenchuk")
				.setStreet("Kyivska")
				.setHouseNumber("6")
				.setLatitude(49.02632)
				.setLongitude(33.23176)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Poltava")
				.setStreet("Yevropeiska")
				.setHouseNumber("187a")
				.setLatitude(49.58943)
				.setLongitude(34.54027)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Zhytomyr")
				.setStreet("Kyivska")
				.setHouseNumber("77")
				.setLatitude(50.24456)
				.setLongitude(28.75385)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Mariupol")
				.setStreet("Myru ave")
				.setHouseNumber("69")
				.setLatitude(47.13254)
				.setLongitude(37.53365)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Rivne")
				.setStreet("Korolenka")
				.setHouseNumber("1")
				.setLatitude(50.61990)
				.setLongitude(26.25161)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Kherson")
				.setStreet("Zalaeherseh")
				.setHouseNumber("18")
				.setLatitude(46.46564)
				.setLongitude(32.22434)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Ternopil")
				.setStreet("Hetmana Ivana Mazepy")
				.setHouseNumber("30")
				.setLatitude(49.55351)
				.setLongitude(25.59476)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Ivano-Frankivsk")
				.setStreet("Ivana Mykolaichuka")
				.setHouseNumber("2")
				.setLatitude(48.92701)
				.setLongitude(24.65268)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Lutsk")
				.setStreet("Sukhomlynskoho")
				.setHouseNumber("1")
				.setLatitude(50.73853)
				.setLongitude(25.54211)
				.buildNewEntity());

		establishmentRepository.save(establishmentBuilder
				.setCountry("Ukraine")
				.setCity("Khmelnytskyi")
				.setStreet("Myru ave")
				.setHouseNumber("99/2a")
				.setLatitude(49.21602)
				.setLongitude(26.61712)
				.buildNewEntity());
	}
}
