package me.bigfanoftim.domaindriven.member.application;

import me.bigfanoftim.domaindriven.common.util.TimeProvider;
import me.bigfanoftim.domaindriven.member.domain.Member;
import me.bigfanoftim.domaindriven.member.domain.MemberId;
import me.bigfanoftim.domaindriven.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeactivationService {

    private final MemberRepository memberRepository;
    private final TimeProvider timeProvider;

    public DeactivationService(MemberRepository memberRepository, TimeProvider timeProvider) {
        this.memberRepository = memberRepository;
        this.timeProvider = timeProvider;
    }

    @Transactional
    public void deactivate(MemberId memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(NoMemberException::new);
        member.deactivate(timeProvider.now());
    }
}
