package GupangMSA.userservice.domain;

import lombok.Getter;

@Getter
public class UserUpdate {

    private final String cardNumber;

    public UserUpdate(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
