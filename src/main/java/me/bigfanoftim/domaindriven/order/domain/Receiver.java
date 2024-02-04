package me.bigfanoftim.domaindriven.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Receiver {

    private String receiverName;
    private String receiverPhoneNumber;
}
