package me.bigfanoftim.domaindriven.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class MemberId implements Serializable {

    @Column(name = "member_id")
    private String id;

    public MemberId() {
    }

    public MemberId(String id) {
        this.id = id;
    }

    public static MemberId createUniqueId() {
        return new MemberId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return Objects.equals(id, memberId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
