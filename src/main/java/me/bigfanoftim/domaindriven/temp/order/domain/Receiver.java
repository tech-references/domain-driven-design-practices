package me.bigfanoftim.domaindriven.temp.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Receiver {

    private String receiverName;
    private String receiverPhoneNumber;

    public Receiver() {
    }

    public Receiver(String receiverName, String receiverPhoneNumber) {
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
    }
}
