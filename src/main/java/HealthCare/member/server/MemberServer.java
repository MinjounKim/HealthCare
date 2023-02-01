package HealthCare.member.server;

import HealthCare.member.entity.Member;
import HealthCare.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServer {

    private final MemberRepository memberRepository;

    public Member createMember(Member member){

        member.setAttendanceCount((long)1);
        member.setMemberSignUp(LocalDate.now());

        return memberRepository.save(member);
    }

    public Member updateMember(String memberName, Member member){

        Member updatemember=memberRepository.findByMemberName(memberName);

        updatemember.setMemberName(member.getMemberName());

        updatemember.setMemberEmail(member.getMemberEmail());

        updatemember.setMemberPhone(member.getMemberPhone());

        updatemember.setMemberPassWord(member.getMemberPassWord());


        return memberRepository.save(updatemember);

    }

    public List<Member> findMembers(){

        return memberRepository.findAll();
    }

    public Member findMember(String memberName){

        return memberRepository.findByMemberName(memberName);
    }

    public void deleteMember(String memberName){

        Member member=memberRepository.findByMemberName(memberName);
        memberRepository.delete(member);
    }
}
