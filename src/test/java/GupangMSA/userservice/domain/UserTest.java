package GupangMSA.userservice.domain;

import GupangMSA.userservice.mock.holder.TestClockHolder;
import GupangMSA.userservice.mock.holder.TestPasswordHolder;
import GupangMSA.userservice.mock.holder.TestUuidHolder;
import GupangMSA.userservice.service.port.holder.ClockHolder;
import GupangMSA.userservice.service.port.holder.PasswordHolder;
import GupangMSA.userservice.service.port.holder.UuidHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {
    @Test
    void UserCreate를_이용해_User를_만들_수_있다() {

        // given
        UserCreate userCreate = UserCreate.builder()
                .name("jang")
                .email("jang@gmail.com")
                .password("password")
                .street("st")
                .postNumber("postNum")
                .city("city")
                .phoneNumber("010-1111-2222")
                .build();
        PasswordHolder passwordHolder = new TestPasswordHolder("drowssap");
        ClockHolder clockHolder = new TestClockHolder(10000);
        UuidHolder uuidHolder = new TestUuidHolder("aaaaaa-bbbbbb-ccccccc");

        // when
        User user = User.from(userCreate, passwordHolder, clockHolder, uuidHolder);


        // then
        assertThat(user.getId()).isNull();
        assertThat(user.getName()).isEqualTo("jang");
        assertThat(user.getEmail()).isEqualTo("jang@gmail.com");
        assertThat(user.getPassword()).isEqualTo("drowssap");
        assertThat(user.getStreet()).isEqualTo("st");
        assertThat(user.getPostNumber()).isEqualTo("postNum");
        assertThat(user.getCity()).isEqualTo("city");
        assertThat(user.getPhoneNumber()).isEqualTo("010-1111-2222");
        assertThat(user.getCardNumber()).isNull();
        assertThat(user.getUserUuid()).isEqualTo("aaaaaa-bbbbbb-ccccccc");
        assertThat(user.getJoinedAt()).isEqualTo(10000);
        assertThat(user.getLastLoginAt()).isNull();
    }

    @Test
    void login_메서드를_통해_로그인_할_수_있다(){

        // when
        User user = User.builder()
                .id(1L)
                .name("jang")
                .email("jang@gmail.com")
                .password("encryptedPassword")
                .city("city")
                .street("st")
                .postNumber("post")
                .cardNumber("1234-5678-2345-3456")
                .userUuid("aaaaaa-bbbbbb-ccccccc")
                .joinedAt(10000L)
                .lastLoginAt(10001L)
                .build();

        ClockHolder clockHolder = new TestClockHolder(20000);

        // when
        user = user.login(clockHolder);


        // then
        assertThat(user.getLastLoginAt()).isEqualTo(20000);
    }

    @Test
    void update_메서드를_통해_카드번호가_없는_경우_업데이트할_수_있다(){

        // givne
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
                .joinedAt(10000L)
                .lastLoginAt(10001L)
                .build();

        UserUpdate userUpdate = new UserUpdate("1111-1111-1111-1111");

        // when
        user = user.update(userUpdate);


        // then
        assertThat(user.getCardNumber()).isEqualTo("1111-1111-1111-1111");
    }

    @Test
    void update_메서드를_통해_카드번호가_있는_경우_업데이트할_수_있다(){

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

        UserUpdate userUpdate = new UserUpdate("1111-1111-1111-1111");

        // when
        user = user.update(userUpdate);

        // then
        assertThat(user.getCardNumber()).isEqualTo("1111-1111-1111-1111");
    }


}
