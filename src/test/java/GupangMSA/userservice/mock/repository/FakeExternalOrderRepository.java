package GupangMSA.userservice.mock.repository;

import GupangMSA.userservice.domain.UserOrder;
import GupangMSA.userservice.service.port.ExternalOrderRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FakeExternalOrderRepository implements ExternalOrderRepository {

    private final List<UserOrder> userOrders;
    @Override
    public List<UserOrder> getUserOrders(Long id) {
        return userOrders;
    }
}
