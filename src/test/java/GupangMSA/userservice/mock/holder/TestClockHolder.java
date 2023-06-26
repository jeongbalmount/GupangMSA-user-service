package GupangMSA.userservice.mock.holder;

import GupangMSA.userservice.service.port.holder.ClockHolder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestClockHolder implements ClockHolder {

    private final long millis;
    @Override
    public long millis() {
        return millis;
    }
}
