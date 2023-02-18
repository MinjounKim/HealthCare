package HealthCare.inbody.server;

import HealthCare.exception.BusinessLogicException;
import HealthCare.exception.ExceptionCode;
import HealthCare.inbody.entity.Inbody;
import HealthCare.inbody.repository.InbodyRepository;
import HealthCare.member.entity.Member;
import HealthCare.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InbodyServer {

    private final InbodyRepository inbodyRepository;

    private final MemberRepository memberRepository;

    public Inbody measurementInbody(String memberName, Inbody inbody){

        Member member=memberRepository.findByMemberName(memberName);

        if(member==null){
            throw new BusinessLogicException(ExceptionCode.Member_NOT_FOUND);
        }

        inbody.setMemberId(member.getMemberId());
        inbody.setMemberName(memberName);
        inbody.setMeasurementDate(LocalDate.now());

        return inbodyRepository.save(inbody);
    }


    public List<Inbody> getMemeberInbodies(String memberName){
        Member member=memberRepository.findByMemberName(memberName);

        if(member==null){
            throw new BusinessLogicException(ExceptionCode.Member_NOT_FOUND);
        }

        return inbodyRepository.findByMemberId(member.getMemberId());
    }

    public List<Inbody> getInbodies(){
        return inbodyRepository.findAll();
    }

}
