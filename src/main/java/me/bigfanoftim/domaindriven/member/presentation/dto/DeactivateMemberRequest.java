package me.bigfanoftim.domaindriven.member.presentation.dto;

import me.bigfanoftim.domaindriven.member.domain.MemberId;

public class DeactivateMemberRequest {

    private MemberId memberId;

    public DeactivateMemberRequest() {
    }

    public DeactivateMemberRequest(MemberId memberId) {
        this.memberId = memberId;
    }

    public MemberId getMemberId() {
        return memberId;
    }
}
