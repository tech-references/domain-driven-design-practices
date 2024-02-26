package me.bigfanoftim.domaindriven.construct;

import jakarta.annotation.PostConstruct;
import me.bigfanoftim.domaindriven.common.model.Email;
import me.bigfanoftim.domaindriven.member.domain.Member;
import me.bigfanoftim.domaindriven.member.domain.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final MemberRepository memberRepository;

    public DataInitializer(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostConstruct
    public void initData() {
        Member member1 = Member.createActiveMember("jun01", new Email("email01@gmail.com"), "password01");
        Member member2 = Member.createActiveMember("jun02", new Email("email02@gmail.com"), "password02");

        memberRepository.saveAll(List.of(member1, member2));
    }
}
