package com.kot.user.test_data;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.kot.user.entity.UserEntity;
import com.kot.user.repository.UserRepository;

@Component
//@Profile("demo")
public class TestUserDataGenerator {

	@Autowired
	private UserRepository userRepository;

	private static final String[] MALE_FIRST_NAMES = {
			"John", "Michael", "William", "James", "David", "Oleksandr", "Andriy", "Ihor", "Mykola", "Petro", "Dmytro",
			"Andrew", "Nik", "Vasyl", "Yaroslav", "Bogdan"
	};

	private static final String[] FEMALE_FIRST_NAMES = {
			"Jane", "Emily", "Olivia", "Sophia", "Emma", "Kateryna", "Olena", "Yulia", "Natalia", "Valeria", "Ivanna",
			"Mira", "Diana", "Anastasia",
	};


	private static final String[] MALE_LAST_NAMES = {
			"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
			"Shevchenko", "Kovalenko", "Ivanov", "Petrov", "Bondarenko", "Tkachenko", "Morozov", "Kozlov", "Zaytsev",
			"Vovkiv", "Bondar", "Koval", "Budko", "Savchuck", "Boreiko", "Dunai", "Vasylenko"
	};

	private static final String[] FEMALE_LAST_NAMES = {
			"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
			"Shevchenko", "Kovalenko", "Ivanova", "Petrova", "Bondarenko", "Tkachenko", "Morozova", "Kozlova", "Zaytseva",
			"Vovkova", "Bondar", "Koval", "Budko", "Savchuck", "Boreiko", "Dunai", "Vasylenko"
	};

	private final String[] CITIES = {"Kyiv", "Kharkiv", "Dnipro", "Khmelnytskyi", "Cherkasy", "Donetsk",
			"Chernihiv", "Sumy", "Zaporizhzhia", "Kryvyi Rih", "Mykolaiv", "Simferopol", "Vinnytsia", "Kremenchuk",
			"Poltava", "Zhytomyr", "Mariupol", "Rivne", "Kherson", "Ternopil", "Ivano-Frankivsk", "Lutsk", "Odessa"};

	private final String[] STREETS = {"Myru ave", "Viacheslava Chornovola ave", "Ivana Mykolaichuka",
			"Hetmana Ivana Mazepy", "Zalaeherseh", "Kyivska", "Svobody ave", "Soborna", "Sadova", "Sukhomlynskoho",
			"Haharina", "Tarasa Shevchenka ave", "Heroiv ave", "Golovna", "Sevastopolska", "Galutska"};

	private static final SecureRandom random = new SecureRandom();

	@PostConstruct
	public void generateTestData() {
//		buildAndSaveUsers();
//		createAndSaveMe();
	}

	private void buildAndSaveUsers() {
		for (int i = 0; i < 5000; i++) {
			UserEntity userEntity = createAndSave();
			System.out.println(userEntity.getId());
		}
	}

	private UserEntity createAndSaveMe() {
		UserEntity userEntity = new UserEntity();
		userEntity.setImageUrl("https://scontent-iev1-1.cdninstagram.com/v/t51.2885-19/89925306_222759988917025_4127506924855885824_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-iev1-1.cdninstagram.com&_nc_cat=101&_nc_ohc=YmOrELE0yVgAX8632io&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfAG1aK0Q8fv0r2D0wdH2mlLZGif_ipMlphnNzNF6_8Ffw&oe=657612E4&_nc_sid=8b3546");
		userEntity.setFirstName("Andrew");
		userEntity.setLastName("Kot");
		Date birthday = new Date();
		birthday.setYear(2001);
		birthday.setMonth(2);
		birthday.setDate(5);
		userEntity.setBirthday(birthday);
		userEntity.setEmail("andrewkot@gmail.com");
		userEntity.setCountry("Ukraine");
		userEntity.setCity("Lviv");
		userEntity.setStreet("Prospect Chornovola");
		String houseNumber = "210A";
		userEntity.setHouseNumber(houseNumber);
		return userRepository.save(userEntity);
	}

	private UserEntity createAndSave() {
		UserEntity userEntity = new UserEntity();
		int randValue = random.nextInt(99);
		if (randValue % 2 == 0) {
			userEntity.setImageUrl("https://randomuser.me/api/portraits/men/" + randValue + ".jpg");
			userEntity.setFirstName(MALE_FIRST_NAMES[random.nextInt(MALE_FIRST_NAMES.length)]);
			userEntity.setLastName(MALE_LAST_NAMES[random.nextInt(MALE_LAST_NAMES.length)]);
		} else {
			userEntity.setImageUrl("https://randomuser.me/api/portraits/women/" + randValue + ".jpg");
			userEntity.setFirstName(FEMALE_FIRST_NAMES[random.nextInt(FEMALE_FIRST_NAMES.length)]);
			userEntity.setLastName(FEMALE_LAST_NAMES[random.nextInt(FEMALE_LAST_NAMES.length)]);
		}
		userEntity.setBirthday(generateRandomBirthday());
		userEntity.setEmail(userEntity.getFirstName().toLowerCase() + "_" + userEntity.getLastName().toLowerCase() + userEntity.getBirthday().getYear() + "@gmail.com");
		userEntity.setCountry("Ukraine");
		userEntity.setCity(CITIES[random.nextInt(CITIES.length)]);
		userEntity.setStreet(STREETS[random.nextInt(STREETS.length)]);
		int randHouseNumber = random.nextInt(150) + 1;
		String houseNumber = randHouseNumber % 4 == 0 ? randHouseNumber + "A" : String.valueOf(randHouseNumber);
		userEntity.setHouseNumber(houseNumber);
		return userRepository.save(userEntity);
	}

	public static Date generateRandomBirthday() {
		int maxAge = 70;
		int minAge = 13;
		int randomAge = random.nextInt(maxAge - minAge + 1) + minAge;

		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.YEAR, -randomAge);

		int dayOfYear = random.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_YEAR)) + 1;
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

		return calendar.getTime();
	}

}
