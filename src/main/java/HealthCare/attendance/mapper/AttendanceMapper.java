package HealthCare.attendance.mapper;

import HealthCare.attendance.dto.ResponseAttendanceDto;
import HealthCare.attendance.entity.Attendance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    List<ResponseAttendanceDto> attendanceToResponseAttendanceDto (List<Attendance> attendances);
}
