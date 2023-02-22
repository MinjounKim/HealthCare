package HealthCare.member.server;

import HealthCare.attendance.entity.Attendance;
import HealthCare.attendance.server.AttendanceServer;
import HealthCare.exception.BusinessLogicException;
import HealthCare.exception.ExceptionCode;
import HealthCare.member.entity.Member;
import HealthCare.member.repository.MemberRepository;
import HealthCare.trainer.entity.Trainer;
import HealthCare.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServer {

    private final MemberRepository memberRepository;

    private final AttendanceServer attendanceServer;

    private final TrainerRepository trainerRepository;

    private final PasswordEncoder passwordEncoder;

    public Member createMember(String trainerName, Member member){

        Trainer trainer=trainerRepository.findByTrainerName(trainerName);

        if(trainer==null){
            throw new BusinessLogicException(ExceptionCode.Trainer_NOT_FOUND);
        }

        // 멤버가 있는 경우 예외 처리
        // 이름은 중복허용, 번호는 중복되는 경우는 없으니 번호로 중복 체크
        if(memberRepository.findByMemberPhone(member.getMemberPhone())!=null){
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }

        // 멤버 비밀번호 암호화
        member.setMemberPassWord(passwordEncoder.encode(member.getMemberPassWord()));

        // 멤버 초기설정
        member.setTrainerId(trainer.getTrainerId());
        member.setAttendanceCount((long)1);
        member.setMemberSignUp(LocalDate.now());

        // 멤버 저장 후 id값 jpa자동생성
        memberRepository.save(member);

        Member memberForAttandence=memberRepository.findByMemberName(member.getMemberName());

        // 자동 생성된 멤버 id값으로 출석server 저장
        attendanceServer.countAttendance(memberForAttandence);

        return memberForAttandence;
    }

    public Member loginMember(String memberName,String memberPassWord){

        Member member=memberRepository.findByMemberName(memberName);

        if(member==null){
            throw new BusinessLogicException(ExceptionCode.Member_NOT_FOUND);
        }

        if(!passwordEncoder.matches(memberPassWord,member.getMemberPassWord())){
            throw new BusinessLogicException(ExceptionCode.PASSWORD_NO_MATCH);
        }

        List<Attendance> attendances=attendanceServer.getAttendance();
        if(!attendances.get(attendances.size()-1).getAttendanceDate().isEqual(LocalDate.now())){
            long count=member.getAttendanceCount();
            count++;
            member.setAttendanceCount(count);

            attendanceServer.countAttendance(member);
        }

        return memberRepository.save(member);
    }

    public Member updateMember(String memberName, Member member){

        Member updatemember=memberRepository.findByMemberName(memberName);

        if(updatemember==null){
            throw new BusinessLogicException(ExceptionCode.Member_NOT_FOUND);
        }

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

        Member member=memberRepository.findByMemberName(memberName);
        if(member==null){
            throw new BusinessLogicException(ExceptionCode.Member_NOT_FOUND);
        }

        return member;
    }

    public void deleteMember(String memberName){

        Member member=memberRepository.findByMemberName(memberName);

        if(member==null){
            throw new BusinessLogicException(ExceptionCode.Member_NOT_FOUND);
        }

        memberRepository.delete(member);
    }
}
