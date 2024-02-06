package me.bigfanoftim.domaindriven.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class ShippingInfo {

    private Receiver receiver;
    private Address address;

    public ShippingInfo() {
    }

    public ShippingInfo(Receiver receiver, Address address) {
        this.receiver = receiver;
        this.address = address;
    }
}
