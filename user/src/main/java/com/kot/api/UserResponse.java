package com.kot.api;

import com.kot.entity.AddressEntity;
import com.kot.entity.Gender;
import com.kot.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private AddressEntity address;

    private LocalDateTime created;

    public UserResponse(UserEntity entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
        this.gender = entity.getGender();
        this.address = entity.getAddress();
        this.created = entity.getCreated();
    }
}
