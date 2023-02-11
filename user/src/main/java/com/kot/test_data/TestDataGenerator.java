package com.kot.test_data;

import com.kot.entity.AddressEntity;
import com.kot.entity.Gender;
import com.kot.entity.UserEntity;
import com.kot.repository.UserRepository;
import com.kot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;
import java.time.LocalDateTime;

@Component
public class TestDataGenerator {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void buildAndSaveTestData() {
        userRepository.deleteAll();

        SecureRandom random = new SecureRandom();
        AddressEntity address = new AddressEntity("Ukraine", "Chernivtsi", "0000");
        String email = "kot@gmail.com";
        UserEntity user = new UserEntity(
                "Andrew",
                "Kot",
                email,
                Gender.MALE,
                address,
                LocalDateTime.now()
        );

        userService.createUser(user);

        for (int i = 0; i < 100; i++) {
            userService.createUser(new UserEntity(
                    "Some",
                    "Incognito",
                    random.nextInt() + email,
                    Gender.MALE,
                    address,
                    LocalDateTime.now()
            ));
        }
    }
}
