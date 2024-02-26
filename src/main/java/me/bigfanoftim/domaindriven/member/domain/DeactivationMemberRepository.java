package me.bigfanoftim.domaindriven.member.domain;

import org.springframework.data.jpa.repository.EntityGraph;

import java.util.Optional;

public interface DeactivationMemberRepository {

    @EntityGraph(attributePaths = {"deactivationHistories"})
    Optional<Member> findWithDeactivationHistoriesById(MemberId memberId);
}
