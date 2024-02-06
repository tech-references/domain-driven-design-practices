package me.bigfanoftim.domaindriven.order.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {
    
    @Test
    @DisplayName("Order의 OrderLine이 없으면, totalAmounts는 0이다.")
    public void totalAmountsZero() throws Exception {
        Order order = createOrder(List.of());
        assertThat(order.getTotalAmounts().getValue()).isEqualTo(0);
    }
    
    private Order createOrder(List<OrderLine> orderLines) {
        OrderNo orderNo = new OrderNo("orderNumber");
        Receiver receiver = new Receiver("hojun", "01065005298");
        Address address = new Address("addr1", "addr2", "zipcode");
        ShippingInfo shippingInfo = new ShippingInfo(receiver, address);
        return new Order(orderNo, shippingInfo, OrderState.PREPARING, orderLines);
    }
}