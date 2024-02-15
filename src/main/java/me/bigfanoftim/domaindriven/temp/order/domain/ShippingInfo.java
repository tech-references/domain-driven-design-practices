package me.bigfanoftim.domaindriven.temp.order.domain;

import jakarta.persistence.*;

@Embeddable
public class ShippingInfo {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zipcode"))
    })
    private Address address;

    @Embedded
    private Receiver receiver;

    @Column(name = "shipping_message")
    private String message;

    public ShippingInfo() {
    }

    public ShippingInfo(Receiver receiver, Address address) {
        this.receiver = receiver;
        this.address = address;
    }
}
