package GupangMSA.userservice.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserResponseTest {

    @Test
    void fromUser_메소드를_사용해서_User에서_UserResponse로_변환할_수_있다() {

        // given
        User user = User.builder()
                .id(1L)
                .name("jang")
                .email("jang@gmail.com")
                .password("encryptedPassword")
                .city("city")
                .street("st")
                .postNumber("post")
                .phoneNumber("010-1111-2222")
                .userUuid("aaaaaa-bbbbbb-ccccccc")
                .cardNumber("1234-2345-3456-4567")
                .joinedAt(10000L)
                .lastLoginAt(10001L)
                .build();


        // when
        UserResponse userResponse = UserResponse.fromUser(user);

        // then
        assertThat(userResponse.getName()).isEqualTo("jang");
        assertThat(userResponse.getEmail()).isEqualTo("jang@gmail.com");
        assertThat(userResponse.getCity()).isEqualTo("city");
        assertThat(userResponse.getStreet()).isEqualTo("st");
        assertThat(userResponse.getPostNumber()).isEqualTo("post");
        assertThat(userResponse.getPhoneNumber()).isEqualTo("010-1111-2222");
        assertThat(userResponse.getJoinedAt()).isEqualTo(10000);

    }
}
