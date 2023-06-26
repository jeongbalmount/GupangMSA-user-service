package GupangMSA.userservice.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {

    private final String name;
    private final String email;
    private final String city;
    private final String street;
    private final String postNumber;
    private final String phoneNumber;
    private final Long joinedAt;

    @Builder
    public UserResponse(String name, String email, String city,
                        String street, String postNumber,
                        String phoneNumber, Long joinedAt) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.street = street;
        this.postNumber = postNumber;
        this.phoneNumber = phoneNumber;
        this.joinedAt = joinedAt;
    }

    public static UserResponse fromUser(User user){
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .city(user.getCity())
                .street(user.getStreet())
                .postNumber(user.getPostNumber())
                .phoneNumber(user.getPhoneNumber())
                .joinedAt(user.getJoinedAt())
                .build();
    }
}
