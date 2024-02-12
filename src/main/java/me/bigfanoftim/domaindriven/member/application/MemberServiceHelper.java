package me.bigfanoftim.domaindriven.member.application;

import me.bigfanoftim.domaindriven.member.domain.Member;
import me.bigfanoftim.domaindriven.member.domain.MemberId;
import me.bigfanoftim.domaindriven.member.domain.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public final class MemberServiceHelper {

    public static Member findExistingMember(MemberRepository memberRepo, MemberId memberId) {
        return memberRepo.findById(memberId).orElseThrow(NoMemberException::new);
    }
}
