package HealthCare.attendance.controller;

import HealthCare.attendance.entity.Attendance;
import HealthCare.attendance.mapper.AttendanceMapper;
import HealthCare.attendance.server.AttendanceServer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@Validated
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceServer attendanceServer;

    private final AttendanceMapper attendanceMapper;

    @PostMapping
    public ResponseEntity postMember(){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAttendance(){

        List<Attendance> attendances=attendanceServer.getAttendance();

        return new ResponseEntity<>(attendanceMapper.attendanceToResponseAttendanceDto(attendances),HttpStatus.OK);
    }

}
