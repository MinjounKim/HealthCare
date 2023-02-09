package HealthCare.member.server;

import HealthCare.attendance.server.AttendanceServer;
import HealthCare.member.entity.Member;
import HealthCare.member.repository.MemberRepository;
import HealthCare.trainer.entity.Trainer;
import HealthCare.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServer {

    private final MemberRepository memberRepository;

    private final AttendanceServer attendanceServer;

    private final TrainerRepository trainerRepository;

    public Member createMember(String trainerName, Member member){

        Trainer trainer=trainerRepository.findByTrainerName(trainerName);

        member.setTrainerId(trainer.getTrainerId());
        member.setAttendanceCount((long)1);
        member.setMemberSignUp(LocalDate.now());

        memberRepository.save(member);

        Member memberForAttandence=memberRepository.findByMemberName(member.getMemberName());

        attendanceServer.countAttendance(memberForAttandence);

        return memberForAttandence;
    }

    public Member loginMember(String memberName){

        Member member=memberRepository.findByMemberName(memberName);

        long count=member.getAttendanceCount();
        count++;
        member.setAttendanceCount(count);

        attendanceServer.countAttendance(member);

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
