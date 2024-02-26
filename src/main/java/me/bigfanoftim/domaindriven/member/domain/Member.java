package me.bigfanoftim.domaindriven.member.domain;

import jakarta.persistence.*;
import me.bigfanoftim.domaindriven.common.audit.BaseEntity;
import me.bigfanoftim.domaindriven.common.model.Email;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member extends BaseEntity {

    @EmbeddedId
    @AttributeOverride(name = "id", column = @Column(name = "id"))
    private MemberId id;

    private String name;

    @Embedded
    private Email email;

    private String password;

    private Boolean isActive;

    @ElementCollection
    @CollectionTable(
            name = "member_deactivation_history",
            joinColumns = @JoinColumn(name = "member_id")
    )
    private final Set<MemberDeactivationHistory> deactivationHistories = new HashSet<>();

    public Member() {
    }

    private Member(MemberId memberId, String name, Email email, String password, Boolean isActive) {
        this.id = memberId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public Member(String name, Email email, String password, Boolean isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public static Member createActiveMember(String name, Email email, String password) {
        return new Member(
                MemberId.createUniqueId(),
                name,
                email,
                password,
                true
        );
    }

    public MemberId getId() {
        return id;
    }

    public void deactivate(LocalDateTime deactivatedAt) {
        verifyActive();

        this.isActive = false;
        deactivationHistories.add(new MemberDeactivationHistory(deactivatedAt));
    }

    public void changePassword(String newPw) {
        this.password = newPw;
    }

    public Set<MemberDeactivationHistory> getDeactivationHistories() {
        return deactivationHistories;
    }

    private void verifyActive() {
        if (!isActive) {
            throw new IllegalStateException("Not active.");
        }
    }
}
