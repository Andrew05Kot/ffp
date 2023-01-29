package com.kot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository repository, MongoTemplate template) {
        return args -> {
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

            UserEntity user1 = new UserEntity(
                    "Some",
                    "Incognito",
                    random.nextInt() + email,
                    Gender.MALE,
                    address,
                    LocalDateTime.now()
            );

            repository.findUserEntityByEmail(email).ifPresentOrElse(u -> {
                System.out.println(u + " already exists");
            }, () -> {
                System.out.println("Inserting the user " + user);
                repository.insert(user);
            });
        };
    }
}