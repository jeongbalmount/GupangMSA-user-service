package GupangMSA.userservice.domain.enums;

/*
    CREATED: 주문이 생성되었지만 아직 처리되지 않았습니다.
    PAID: 결제가 완료된 상태
    SHIPPED: 주문 상품이 배송되었거나 고객에게 배송되는 중입니다.
    DELIVERED: 주문이 고객에게 성공적으로 전달되었습니다.
    CANCELLED: 주문이 고객 또는 다른 이유로 취소되었습니다.
*/

public enum OrderStatus {

    CREATED, PAID, SHIPPED, DELIVERED, CANCELLED

}
