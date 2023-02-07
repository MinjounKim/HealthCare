package HealthCare.inbody.repository;

import HealthCare.inbody.entity.Inbody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InbodyRepository extends JpaRepository<Inbody, Long> {

    List<Inbody> findByMemberId(Long memberId);
}
