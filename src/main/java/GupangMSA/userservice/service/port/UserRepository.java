package GupangMSA.userservice.service.port;

import GupangMSA.userservice.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

    User save(User user);

}
