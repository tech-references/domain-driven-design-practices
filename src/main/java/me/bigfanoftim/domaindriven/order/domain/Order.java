package me.bigfanoftim.domaindriven.order.domain;

import jakarta.persistence.*;
import me.bigfanoftim.domaindriven.common.jpa.MoneyConverter;
import me.bigfanoftim.domaindriven.common.model.Money;

import java.util.List;

@Entity
@Table(name = "purchase_order")
public class Order {

    @EmbeddedId
    private OrderNo number;

    @Embedded
    private ShippingInfo shippingInfo;

    @Enumerated(value = EnumType.STRING)
    private OrderState state;

    // MoneyConverter에서 autoApply를 false(기본값)로 설정하면 직접 지정해야 한다.
    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter.class)
    private Money totalAmounts;

    // 밸류 컬렉션을 별도의 테이블로 매핑할 때 @ElementCollection, @CollectionTable 사용
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_line",
            joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    /**
     * OrderState 뿐만 아니라 다른 정보도 함께 사용하여 changeable 한지 확인하려면 OrderState 대신
     * Order 객체에서 처리해야 함
     */
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        this.shippingInfo = newShippingInfo;
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void verifyNotYetShipped() {
        if (!state.isNotYetShipped()) {
            throw new IllegalStateException("already shipped");
        }
    }

    private Money calculateTotalAmounts() {
        return orderLines.stream()
                .map(OrderLine::getAmounts)
                .reduce(
                        new Money(0), // 초기값
                        (totalAmount, currentAmount) -> new Money(totalAmount.getValue() + currentAmount.getValue())
                );
    }
}