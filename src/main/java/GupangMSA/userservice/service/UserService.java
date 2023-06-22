package GupangMSA.userservice.service;

import GupangMSA.userservice.domain.User;
import GupangMSA.userservice.domain.UserCreate;
import GupangMSA.userservice.service.port.UserRepository;
import GupangMSA.userservice.service.port.holder.ClockHolder;
import GupangMSA.userservice.service.port.holder.PasswordHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ClockHolder clockHolder;
    private final PasswordHolder passwordHolder;

    public void create(UserCreate userCreate) {
        User.from(userCreate, passwordHolder, clockHolder);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("no user exception"));
    }

    public void login(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("no user exception");
        }
        User user = optionalUser.get();
        user = user.login(clockHolder);
        userRepository.save(user);
    }





}
