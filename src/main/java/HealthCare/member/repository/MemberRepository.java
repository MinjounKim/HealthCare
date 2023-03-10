package HealthCare.member.repository;

import HealthCare.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemberName(String memberName);

    Member findByMemberPhone(String memberPhone);
}
