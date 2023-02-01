package HealthCare.attendance.server;

import HealthCare.attendance.entity.Attendance;
import HealthCare.attendance.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServer {

    private final AttendanceRepository attendanceRepository;

    public void countAttendance(Attendance attendance){

        attendance.setAttendanceDate(LocalDate.now());

        attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendance(){
        return attendanceRepository.findAll();
    }
}
