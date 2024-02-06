package me.bigfanoftim.domaindriven.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipCode;

    public Address() {
    }

    public Address(String shippingAddress1, String shippingAddress2, String shippingZipCode) {
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingZipCode = shippingZipCode;
    }
}
