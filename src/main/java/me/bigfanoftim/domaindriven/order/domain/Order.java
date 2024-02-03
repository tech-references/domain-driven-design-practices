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

    /**
     * MoneyConverter에서 autoApply를 false(기본값)로 설정하면 직접 지정해야 한다.
     */
    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter.class)
    private Money totalAmounts;

    /**
     * 밸류 컬렉션을 별도의 테이블로 매핑할 때 @ElementCollection, @CollectionTable 사용
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_line",
            joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;
}
