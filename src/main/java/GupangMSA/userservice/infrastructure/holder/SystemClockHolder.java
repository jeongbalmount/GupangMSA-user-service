package GupangMSA.userservice.infrastructure.holder;

import GupangMSA.userservice.service.port.holder.ClockHolder;
import org.springframework.stereotype.Component;

@Component
public class SystemClockHolder implements ClockHolder {
    @Override
    public long millis() {
        return System.currentTimeMillis();
    }
}
