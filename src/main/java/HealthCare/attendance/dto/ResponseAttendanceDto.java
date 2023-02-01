package HealthCare.attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ResponseAttendanceDto {

    private String memberName;

    private LocalDate attendanceDate;

}
