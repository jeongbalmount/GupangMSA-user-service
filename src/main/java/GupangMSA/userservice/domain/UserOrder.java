package GupangMSA.userservice.domain;

import GupangMSA.userservice.domain.enums.OrderStatus;
import lombok.Getter;

// 주문은
/*
    - 주문 회원 id
    - 주문한 상품
        - 주문 상품 이름
        - 주문 상품 가격
        - 주문 상품 개수
    - 주문한 시간태
    - 배송 주소 => (city, street, zipcode)
    - 주문 상태
 */

@Getter
public class UserOrder {

    private final Long userId;
    private final String productName;
    private final String productPrice;
    private final int productCount;
    private final Long orderedTime;
    private final String city;
    private final String street;
    private final String zipcode;
    private final OrderStatus status;

    public UserOrder(Long userId, String productName,
                     String productPrice, int productCount, Long orderedTime,
                     String city, String street, String zipcode, OrderStatus status) {
        this.userId = userId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.orderedTime = orderedTime;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.status = status;
    }
}
