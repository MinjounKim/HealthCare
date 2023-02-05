package HealthCare.attendance.server;

import HealthCare.attendance.entity.Attendance;
import HealthCare.attendance.repository.AttendanceRepository;
import HealthCare.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServer {

    private final AttendanceRepository attendanceRepository;

    public void countAttendance(Member member){

        Attendance attendance=new Attendance();

        attendance.setMemberId(member.getMemberId());
        attendance.setMemberName(member.getMemberName());
        attendance.setAttendanceDate(LocalDate.now());

        attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendance(){
        return attendanceRepository.findAll();
    }

    public List<Attendance> getMemeberAttendances(String memberName){
        return attendanceRepository.findByMemberName(memberName);
    }


}
