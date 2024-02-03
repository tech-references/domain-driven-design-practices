package me.bigfanoftim.domaindriven.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * JPA에서 식별자 타입은 Serializable 타입이어야 하므로
 * 밸류 타입은 Serializable 인터페이스 상속받아야 한다.
 */
@Embeddable
public class OrderNo implements Serializable {

    @Column(name = "order_number")
    private String number;

    /**
     * 밸류 타입으로 식별자를 구성하면 식별자에 기능을 추가할 수 있다는 장점이 있다.
     * 1세대 시스템의 주문번호와 2세대 시스템의 주문번호를 구분하는 기능
     *
     * if (order.getNumber().is2ndGeneration()) { ... }
     */
    public boolean is2ndGeneration() {
        return number.startsWith("N");
    }

    /**
     * 식별자로 사용되는 밸류 타입이기 때문에 equals(), hashCode() 구현을 잊지 말자.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderNo orderNo = (OrderNo) o;
        return Objects.equals(number, orderNo.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
