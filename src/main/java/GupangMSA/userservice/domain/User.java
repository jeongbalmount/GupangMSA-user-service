package GupangMSA.userservice.domain;

import GupangMSA.userservice.service.port.holder.ClockHolder;
import GupangMSA.userservice.service.port.holder.PasswordHolder;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class User {
    private final Long id;
    private final String name;
    private final String email;
    private final String password;
    private final String city;
    private final String street;
    private final String postNumber;
    private final String phoneNumber;
    private final String cardNumber;
    private final String userUuid;
    private final Long joinedAt;
    private final Long lastLoginAt;

    @Builder
    public User(Long id, String name, String email, String password,
                String city, String street, String postNumber, String phoneNumber,
                String cardNumber, String userUuid, Long joinedAt, Long lastLoginAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.postNumber = postNumber;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        this.userUuid = userUuid;
        this.joinedAt = joinedAt;
        this.lastLoginAt = lastLoginAt;
    }

    public static User from(UserCreate userCreate, PasswordHolder passwordHolder, ClockHolder clockHolder) {
        String uuid = UUID.randomUUID().toString();
        return User.builder()
                .name(userCreate.getName())
                .email(userCreate.getEmail())
                .password(passwordHolder.password())
                .city(userCreate.getCity())
                .street(userCreate.getStreet())
                .postNumber(userCreate.getPostNumber())
                .phoneNumber(userCreate.getPhoneNumber())
                .userUuid(uuid)
                .joinedAt(clockHolder.millis())
                .build();
    }

    public User login(ClockHolder clockHolder) {
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .city(city)
                .street(street)
                .postNumber(postNumber)
                .phoneNumber(phoneNumber)
                .cardNumber(cardNumber)
                .userUuid(userUuid)
                .joinedAt(joinedAt)
                .lastLoginAt(clockHolder.millis())
                .build();
    }

    public User update(UserUpdate userUpdate) {
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .city(city)
                .street(street)
                .postNumber(postNumber)
                .phoneNumber(phoneNumber)
                .cardNumber(userUpdate.getCardNumber())
                .userUuid(userUuid)
                .joinedAt(joinedAt)
                .lastLoginAt(lastLoginAt)
                .build();
    }


}


