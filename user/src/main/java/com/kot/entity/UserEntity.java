package com.kot.entity;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@QueryEntity
@TypeAlias("user")
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = UserEntity.COLLECTION_NAME)
public class UserEntity {

    public static final String COLLECTION_NAME = "db_user";

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Indexed(unique = true)
    private String email;

    private Gender gender;

    private AddressEntity address;

    private LocalDateTime created;

    public UserEntity(String firstName, String lastName, String email, Gender gender, AddressEntity address, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.created = created;
    }
}
