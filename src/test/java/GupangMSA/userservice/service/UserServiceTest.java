package GupangMSA.userservice.service;

import GupangMSA.userservice.domain.User;
import GupangMSA.userservice.domain.UserCreate;
import GupangMSA.userservice.domain.UserUpdate;
import GupangMSA.userservice.mock.repository.FakeUserRepository;
import GupangMSA.userservice.mock.holder.TestClockHolder;
import GupangMSA.userservice.mock.holder.TestPasswordHolder;
import GupangMSA.userservice.mock.holder.TestUuidHolder;
import GupangMSA.userservice.service.port.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void init() {
        UserRepository fakeRepository = new FakeUserRepository();
        this.userService = new UserService(fakeRepository,
                new TestClockHolder(30000L),
                new TestPasswordHolder("drowssap"),
                new TestUuidHolder("aaaaaa-bbbbbb-cccccc"));

        User user1 = User.builder()
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
        User user2 = User.builder()
                .id(2L)
                .name("kim")
                .email("kim@gmail.com")
                .password("encryptedPassword2")
                .city("city2")
                .street("st2")
                .postNumber("post2")
                .phoneNumber("010-2222-3333")
                .userUuid("aaaaaa-bbbbbb-dddddd")
                .cardNumber("1234-1234-3456-3456")
                .joinedAt(20000L)
                .lastLoginAt(20002L)
                .build();
        fakeRepository.save(user1);
        fakeRepository.save(user2);
    }

    @Test
    void create로_회원을_새로_등록할_수_있다() {
        // given
        UserCreate userCreate = new UserCreate("kang", "kang@gmail.com", "password",
                "seoul", "street", "post3", "010-1111-3333");

        // when
        User user = userService.create(userCreate);


        // then
        assertThat(user.getId()).isNotNull();
        assertThat(user.getName()).isEqualTo("kang");
        assertThat(user.getJoinedAt()).isEqualTo(30000L);
        assertThat(user.getPassword()).isEqualTo("drowssap");
        assertThat(user.getUserUuid()).isEqualTo("aaaaaa-bbbbbb-cccccc");

    }

    @Test
    void findById로_회원정보를_찾을_수_있다() {

        // when
        User user = this.userService.findById(1L);

        // then
        assertThat(user.getName()).isEqualTo("jang");
        assertThat(user.getEmail()).isEqualTo("jang@gmail.com");
        assertThat(user.getCity()).isEqualTo("city");
        assertThat(user.getStreet()).isEqualTo("st");
        assertThat(user.getPostNumber()).isEqualTo("post");
        assertThat(user.getPhoneNumber()).isEqualTo("010-1111-2222");
        assertThat(user.getJoinedAt()).isEqualTo(10000L);
    }

    @Test
    void login으로_회원로그인을_한다() {

        // when
        userService.login(1L);

        // then
        User user = userService.findById(1L);
        assertThat(user.getLastLoginAt()).isEqualTo(30000L);

    }

    @Test
    void update로_회원의_카드번호를_업데이트_한다() {

        // given
        UserUpdate userUpdate = new UserUpdate("1111-2222-3333-4444");

        // when
        userService.update(1L, userUpdate);

        // then
        User user = userService.findById(1L);
        assertThat(user.getCardNumber()).isEqualTo("1111-2222-3333-4444");

    }
}
