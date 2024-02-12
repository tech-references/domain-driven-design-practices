package me.bigfanoftim.domaindriven.member.application;

import me.bigfanoftim.domaindriven.member.domain.Member;
import me.bigfanoftim.domaindriven.member.domain.MemberId;
import me.bigfanoftim.domaindriven.member.domain.MemberRepository;
import org.springframework.stereotype.Service;

import static me.bigfanoftim.domaindriven.member.application.MemberServiceHelper.findExistingMember;

@Service
public class ChangePasswordService {

    private MemberRepository memberRepository;

    public ChangePasswordService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void changePassword(MemberId memberId, String newPw) {
        Member member = findExistingMember(memberRepository, memberId);
        member.changePassword(newPw);
    }
}
