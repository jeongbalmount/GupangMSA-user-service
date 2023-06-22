package GupangMSA.userservice.domain;

import lombok.Getter;

@Getter
public class UserCreate {

    private final String name;
    private final String email;
    private final String password;
    private final String city;
    private final String street;
    private final String postNumber;
    private final String phoneNumber;

    public UserCreate(String name, String email, String password, String city,
                      String street, String postNumber, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.postNumber = postNumber;
        this.phoneNumber = phoneNumber;
    }
}
