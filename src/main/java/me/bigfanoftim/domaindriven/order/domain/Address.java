package me.bigfanoftim.domaindriven.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipCode;
}
