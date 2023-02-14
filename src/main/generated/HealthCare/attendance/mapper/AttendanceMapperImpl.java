package HealthCare.attendance.mapper;

import HealthCare.attendance.dto.ResponseAttendanceDto;
import HealthCare.attendance.entity.Attendance;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T17:06:47+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class AttendanceMapperImpl implements AttendanceMapper {

    @Override
    public List<ResponseAttendanceDto> attendanceToResponseAttendanceDto(List<Attendance> attendances) {
        if ( attendances == null ) {
            return null;
        }

        List<ResponseAttendanceDto> list = new ArrayList<ResponseAttendanceDto>( attendances.size() );
        for ( Attendance attendance : attendances ) {
            list.add( attendanceToResponseAttendanceDto1( attendance ) );
        }

        return list;
    }

    protected ResponseAttendanceDto attendanceToResponseAttendanceDto1(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }

        ResponseAttendanceDto.ResponseAttendanceDtoBuilder responseAttendanceDto = ResponseAttendanceDto.builder();

        responseAttendanceDto.memberName( attendance.getMemberName() );
        responseAttendanceDto.attendanceDate( attendance.getAttendanceDate() );

        return responseAttendanceDto.build();
    }
}
