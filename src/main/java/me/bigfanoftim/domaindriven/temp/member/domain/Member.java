package me.bigfanoftim.domaindriven.temp.member.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Member {

    @EmbeddedId
    @AttributeOverride(name = "member_id", column = @Column(name = "id"))
    private MemberId memberId;

    private String name;

    private String password;

    public Member() {
    }

    public Member(MemberId memberId, String name, String password) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
    }

    public void changePassword(String newPw) {
        this.password = newPw;
    }
}
