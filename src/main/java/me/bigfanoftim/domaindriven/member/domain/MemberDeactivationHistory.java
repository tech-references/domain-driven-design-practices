package me.bigfanoftim.domaindriven.member.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class MemberDeactivationHistory {

    private LocalDateTime deactivatedAt;

    protected MemberDeactivationHistory() {
    }

    public MemberDeactivationHistory(LocalDateTime deactivatedAt) {
        this.deactivatedAt = deactivatedAt;
    }
}
