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

    public OrderNo() {
    }

    public OrderNo(String number) {
        this.number = number;
    }

    public boolean is2ndGeneration() {
        return number.startsWith("N");
    }

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
