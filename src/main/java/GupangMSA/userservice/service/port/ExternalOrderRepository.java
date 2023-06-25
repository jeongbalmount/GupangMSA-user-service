package GupangMSA.userservice.service.port;

import GupangMSA.userservice.domain.UserOrder;

import java.util.List;

public interface ExternalOrderRepository {

    List<UserOrder> getUserOrders(Long id);
}
