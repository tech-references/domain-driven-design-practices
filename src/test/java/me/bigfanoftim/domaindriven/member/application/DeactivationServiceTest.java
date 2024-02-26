package me.bigfanoftim.domaindriven.member.application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.bigfanoftim.domaindriven.common.model.Email;
import me.bigfanoftim.domaindriven.member.domain.Member;
import me.bigfanoftim.domaindriven.member.domain.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class DeactivationServiceTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    DeactivationService deactivationService;

    @Autowired
    MemberRepository memberRepository;

    @Nested
    @DisplayName("deactivate()")
    class Deactivate {

        private Member member;

        @BeforeEach
        void setUp() {
            Email email = new Email("bigfanoftim@gmail.com");
            member = Member.createActiveMember("jun", email, "password");
            memberRepository.save(member);
        }

        @Test
        @DisplayName("pass")
        public void pass() throws Exception {
            deactivationService.deactivate(member.getId());

            entityManager.flush();
            entityManager.clear();

            deactivationService.deactivate(member.getId());

            entityManager.flush();
            entityManager.clear();

            deactivationService.deactivate(member.getId());

            Member foundMember = memberRepository.findById(member.getId()).get();
            assertThat(foundMember.getDeactivationHistories().size()).isEqualTo(1);
        }
    }
}