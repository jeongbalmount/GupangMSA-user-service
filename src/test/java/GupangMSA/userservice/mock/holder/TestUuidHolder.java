package GupangMSA.userservice.mock.holder;

import GupangMSA.userservice.service.port.holder.UuidHolder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestUuidHolder implements UuidHolder {

    private final String uuid;
    @Override
    public String random() {
        return uuid;
    }
}
