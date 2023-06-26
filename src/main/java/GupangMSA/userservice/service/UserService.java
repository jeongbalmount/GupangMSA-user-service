package GupangMSA.userservice.service;

import GupangMSA.userservice.domain.User;
import GupangMSA.userservice.domain.UserCreate;
import GupangMSA.userservice.domain.UserResponse;
import GupangMSA.userservice.domain.UserUpdate;
import GupangMSA.userservice.service.port.UserRepository;
import GupangMSA.userservice.service.port.holder.ClockHolder;
import GupangMSA.userservice.service.port.holder.PasswordHolder;
import GupangMSA.userservice.service.port.holder.UuidHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ClockHolder clockHolder;
    private final PasswordHolder passwordHolder;
    private final UuidHolder uuidHolder;

    public User create(UserCreate userCreate) {
        return userRepository.save(User.from(userCreate,
                passwordHolder, clockHolder, uuidHolder));
    }

    public User findById(Long id) {
        return getUser(id);
    }

    public void login(Long id) {
        User user = getUser(id);
        user = user.login(clockHolder);
        userRepository.save(user);
    }

    public void update(Long id, UserUpdate update) {
        User user = getUser(id);
        user = user.update(update);
        userRepository.save(user);
    }

    private User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("no user exception");
        }
        return optionalUser.get();
    }

}
