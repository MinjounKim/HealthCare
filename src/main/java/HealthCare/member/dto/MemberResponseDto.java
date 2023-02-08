package HealthCare.member.dto;

import HealthCare.attendance.dto.ResponseAttendanceDto;
import HealthCare.attendance.entity.Attendance;
import HealthCare.inbody.dto.ResponseInbodyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class MemberResponseDto {

    private String memberName;

    private String memberEmail;

    private String memberPhone;

    private Long attendanceCount;

    private List<ResponseAttendanceDto> attendances;

    private List<ResponseInbodyDto> inbodies;

}
