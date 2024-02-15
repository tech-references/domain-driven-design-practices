package me.bigfanoftim.domaindriven.temp.order.domain;

import jakarta.persistence.*;
import me.bigfanoftim.domaindriven.temp.member.domain.MemberId;

@Embeddable
public class Orderer {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

    public Orderer() {
    }

    public Orderer(MemberId memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
