package GupangMSA.userservice.service;

import GupangMSA.userservice.domain.UserOrder;
import GupangMSA.userservice.domain.UserReview;
import GupangMSA.userservice.domain.enums.OrderStatus;
import GupangMSA.userservice.mock.repository.FakeExternalOrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExternalOrderServiceTest {

    private ExternalOrderService externalOrderService;
    @BeforeEach
    void init() {

        List<UserOrder> userOrders = new ArrayList<>();
        UserOrder userOrder = UserOrder.builder()
                .userId(1L)
                .productName("apple")
                .productPrice(10000)
                .productCount(1)
                .orderedTime(10000L)
                .city("city")
                .street("st")
                .zipcode("zip")
                .status(OrderStatus.CREATED)
                .build();
        UserOrder userOrder2 = UserOrder.builder()
                .userId(1L)
                .productName("orange")
                .productPrice(20000)
                .productCount(2)
                .orderedTime(20000L)
                .city("city2")
                .street("st2")
                .zipcode("zip2")
                .status(OrderStatus.PAID)
                .build();
        UserOrder userOrder3 = UserOrder.builder()
                .userId(1L)
                .productName("mango")
                .productPrice(30000)
                .productCount(3)
                .orderedTime(30000L)
                .city("city3")
                .street("st3")
                .zipcode("zip3")
                .status(OrderStatus.SHIPPED)
                .build();

        userOrders.add(userOrder);
        userOrders.add(userOrder2);
        userOrders.add(userOrder3);

        this.externalOrderService = new ExternalOrderService(new FakeExternalOrderRepository(userOrders));

    }

    @Test
    void getUserOrders를_통해_해당_회원의_주문들을_가져올_수_있다() {
        // given

        // when
        List<UserOrder> userOrders = externalOrderService.getUserOrders(1L);

        // then
        assertThat(userOrders.get(0).getUserId()).isEqualTo(1L);
        assertThat(userOrders.get(0).getProductPrice()).isEqualTo(10000);
        assertThat(userOrders.get(0).getStatus()).isEqualTo(OrderStatus.CREATED);

        assertThat(userOrders.get(1).getUserId()).isEqualTo(1L);
        assertThat(userOrders.get(1).getProductPrice()).isEqualTo(20000);
        assertThat(userOrders.get(1).getStatus()).isEqualTo(OrderStatus.PAID);

        assertThat(userOrders.get(2).getUserId()).isEqualTo(1L);
        assertThat(userOrders.get(2).getProductPrice()).isEqualTo(30000);
        assertThat(userOrders.get(2).getStatus()).isEqualTo(OrderStatus.SHIPPED);
    }
}
