package GupangMSA.userservice.mock.holder;

import GupangMSA.userservice.service.port.holder.PasswordHolder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestPasswordHolder implements PasswordHolder {

    private final String encryptedPassword;
    @Override
    public String password(String notEncryptedPassword) {
        return encryptedPassword;
    }
}
