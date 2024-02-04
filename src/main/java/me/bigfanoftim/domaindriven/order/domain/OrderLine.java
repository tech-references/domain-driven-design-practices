package me.bigfanoftim.domaindriven.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import me.bigfanoftim.domaindriven.common.jpa.MoneyConverter;
import me.bigfanoftim.domaindriven.common.model.Money;

@Embeddable
public class OrderLine {

    @Embedded
    private String productId;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "amounts")
    private Money amounts;

    protected OrderLine() {
    }

    public OrderLine(String productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price; // Money는 불변이기 때문에 새로 객체를 생성할 필요가 없음
        this.quantity = quantity;
        this.amounts = calculateAmounts(); // price, quantity 할당된 후 호출
    }

    public Money getAmounts() {
        return amounts;
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
