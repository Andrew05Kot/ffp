package com.kot.establishment.test_data;

import java.security.SecureRandom;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.kot.establishment.repository.EstablishmentRepository;

@Component
//@Profile("testdata")
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
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kyiv")
                .setStreet("Sevastopolska")
                .setHouseNumber("1")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kharkiv")
                .setStreet("Pavlivska")
                .setHouseNumber("6")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kyiv")
                .setStreet("Khreshchatyk")
                .setHouseNumber("19a")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kyiv")
                .setStreet("Borychiv")
                .setHouseNumber("10a")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kyiv")
                .setStreet("Yevhena Sverstiuka")
                .setHouseNumber("1")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kyiv")
                .setStreet("Teodora Draizera")
                .setHouseNumber("4")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Dnipro")
                .setStreet("Staromostova")
                .setHouseNumber("5")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kharkiv")
                .setStreet("Suzdalski Riady")
                .setHouseNumber("9")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kyiv")
                .setStreet("Borshchahivska")
                .setHouseNumber("2b")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Dnipro")
                .setStreet("Yuriia Kondratiuka")
                .setHouseNumber("2b")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Dnipro")
                .setStreet("Heroiv ave")
                .setHouseNumber("1v")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Odesa")
                .setStreet("Dobrovolskoho ave")
                .setHouseNumber("116")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Cherkasy")
                .setStreet("Smilianska")
                .setHouseNumber("31")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Donetsk")
                .setStreet("Komunariv")
                .setHouseNumber("1a")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Chernihiv")
                .setStreet("Kyrponosa")
                .setHouseNumber("34")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kyiv")
                .setStreet("Yuriia Haharina")
                .setHouseNumber("2a")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Sumy")
                .setStreet("Pokrovska")
                .setHouseNumber("15a")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Lviv")
                .setStreet("Tarasa Shevchenka ave")
                .setHouseNumber("7")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Zaporizhzhia")
                .setStreet("Sobornyi ave")
                .setHouseNumber("1999")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kryvyi Rih")
                .setStreet("Haharina ave.")
                .setHouseNumber("2")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Mykolaiv")
                .setStreet("Admirala Makarova")
                .setHouseNumber("43")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Simferopol")
                .setStreet("Haharina")
                .setHouseNumber("6")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Lviv")
                .setStreet("Viacheslava Chornovola ave")
                .setHouseNumber("12")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Vinnytsia")
                .setStreet("Soborna")
                .setHouseNumber("51a")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kharkiv")
                .setStreet("Poltavskyi Shliakh")
                .setHouseNumber("58/1")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Lviv")
                .setStreet("Svobody ave")
                .setHouseNumber("35")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kremenchuk")
                .setStreet("Kyivska")
                .setHouseNumber("6")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Poltava")
                .setStreet("Yevropeiska")
                .setHouseNumber("187a")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Zhytomyr")
                .setStreet("Kyivska")
                .setHouseNumber("77")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Mariupol")
                .setStreet("Myru ave")
                .setHouseNumber("69")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Rivne")
                .setStreet("Korolenka")
                .setHouseNumber("1")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Kherson")
                .setStreet("Zalaeherseh")
                .setHouseNumber("18")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Ternopil")
                .setStreet("Hetmana Ivana Mazepy")
                .setHouseNumber("30")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Ivano-Frankivsk")
                .setStreet("Ivana Mykolaichuka")
                .setHouseNumber("2")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Lutsk")
                .setStreet("Sukhomlynskoho")
                .setHouseNumber("1")
                .buildNewEntity());

        establishmentRepository.save(establishmentBuilder
                .setCountry("Ukraine")
                .setCity("Khmelnytskyi")
                .setStreet("Myru ave")
                .setHouseNumber("99/2a")
                .buildNewEntity());
    }
}
