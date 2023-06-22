package GupangMSA.userservice.infrastructure.holder;

import GupangMSA.userservice.service.port.holder.UuidHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SystemUuidHolder implements UuidHolder {

    @Override
    public String random() {
        return UUID.randomUUID().toString();
    }
}
