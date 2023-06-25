package GupangMSA.userservice.service;

import GupangMSA.userservice.domain.UserOrder;
import GupangMSA.userservice.service.port.ExternalOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalOrderService {

    private final ExternalOrderRepository externalOrderRepository;

    public List<UserOrder> getUserOrders(Long id) {
        return externalOrderRepository.getUserOrders(id);
    }

}
