package HealthCare.member.mapper;

import HealthCare.attendance.dto.ResponseAttendanceDto;
import HealthCare.attendance.entity.Attendance;
import HealthCare.inbody.dto.ResponseInbodyDto;
import HealthCare.inbody.entity.Inbody;
import HealthCare.member.dto.MemberPatchDto;
import HealthCare.member.dto.MemberPostDto;
import HealthCare.member.dto.MemberResponseDto;
import HealthCare.member.entity.Member;
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
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoTomember(MemberPostDto memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberName( memberPostDto.getMemberName() );
        member.setMemberPassWord( memberPostDto.getMemberPassWord() );
        member.setMemberEmail( memberPostDto.getMemberEmail() );
        member.setMemberPhone( memberPostDto.getMemberPhone() );

        return member;
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseDto.MemberResponseDtoBuilder memberResponseDto = MemberResponseDto.builder();

        memberResponseDto.memberName( member.getMemberName() );
        memberResponseDto.memberEmail( member.getMemberEmail() );
        memberResponseDto.memberPhone( member.getMemberPhone() );
        memberResponseDto.attendanceCount( member.getAttendanceCount() );
        memberResponseDto.attendances( attendanceListToResponseAttendanceDtoList( member.getAttendances() ) );
        memberResponseDto.inbodies( inbodyListToResponseInbodyDtoList( member.getInbodies() ) );

        return memberResponseDto.build();
    }

    @Override
    public Member memberPatchDtoTomember(MemberPatchDto memberPatchDto) {
        if ( memberPatchDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberName( memberPatchDto.getMemberName() );
        member.setMemberPassWord( memberPatchDto.getMemberPassWord() );
        member.setMemberEmail( memberPatchDto.getMemberEmail() );
        member.setMemberPhone( memberPatchDto.getMemberPhone() );

        return member;
    }

    @Override
    public List<MemberResponseDto> membersToMemberResponseDtos(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<MemberResponseDto> list = new ArrayList<MemberResponseDto>( members.size() );
        for ( Member member : members ) {
            list.add( memberToMemberResponseDto( member ) );
        }

        return list;
    }

    @Override
    public MemberResponseDto memberAndAttendancesToResponseDto(Member member, List<Attendance> attendances) {
        if ( member == null && attendances == null ) {
            return null;
        }

        MemberResponseDto.MemberResponseDtoBuilder memberResponseDto = MemberResponseDto.builder();

        if ( member != null ) {
            memberResponseDto.memberName( member.getMemberName() );
            memberResponseDto.memberEmail( member.getMemberEmail() );
            memberResponseDto.memberPhone( member.getMemberPhone() );
            memberResponseDto.attendanceCount( member.getAttendanceCount() );
            memberResponseDto.attendances( attendanceListToResponseAttendanceDtoList( member.getAttendances() ) );
            memberResponseDto.inbodies( inbodyListToResponseInbodyDtoList( member.getInbodies() ) );
        }

        return memberResponseDto.build();
    }

    @Override
    public MemberResponseDto memberAndInbodiesToResponseDto(Member member, List<Inbody> inbodies) {
        if ( member == null && inbodies == null ) {
            return null;
        }

        MemberResponseDto.MemberResponseDtoBuilder memberResponseDto = MemberResponseDto.builder();

        if ( member != null ) {
            memberResponseDto.memberName( member.getMemberName() );
            memberResponseDto.memberEmail( member.getMemberEmail() );
            memberResponseDto.memberPhone( member.getMemberPhone() );
            memberResponseDto.attendanceCount( member.getAttendanceCount() );
            memberResponseDto.attendances( attendanceListToResponseAttendanceDtoList( member.getAttendances() ) );
            memberResponseDto.inbodies( inbodyListToResponseInbodyDtoList( member.getInbodies() ) );
        }

        return memberResponseDto.build();
    }

    protected ResponseAttendanceDto attendanceToResponseAttendanceDto(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }

        ResponseAttendanceDto.ResponseAttendanceDtoBuilder responseAttendanceDto = ResponseAttendanceDto.builder();

        responseAttendanceDto.memberName( attendance.getMemberName() );
        responseAttendanceDto.attendanceDate( attendance.getAttendanceDate() );

        return responseAttendanceDto.build();
    }

    protected List<ResponseAttendanceDto> attendanceListToResponseAttendanceDtoList(List<Attendance> list) {
        if ( list == null ) {
            return null;
        }

        List<ResponseAttendanceDto> list1 = new ArrayList<ResponseAttendanceDto>( list.size() );
        for ( Attendance attendance : list ) {
            list1.add( attendanceToResponseAttendanceDto( attendance ) );
        }

        return list1;
    }

    protected ResponseInbodyDto inbodyToResponseInbodyDto(Inbody inbody) {
        if ( inbody == null ) {
            return null;
        }

        ResponseInbodyDto.ResponseInbodyDtoBuilder responseInbodyDto = ResponseInbodyDto.builder();

        responseInbodyDto.inbodyId( inbody.getInbodyId() );
        responseInbodyDto.memberId( inbody.getMemberId() );
        responseInbodyDto.memberName( inbody.getMemberName() );
        responseInbodyDto.measurementDate( inbody.getMeasurementDate() );
        responseInbodyDto.arms( inbody.getArms() );
        responseInbodyDto.legs( inbody.getLegs() );
        responseInbodyDto.body( inbody.getBody() );

        return responseInbodyDto.build();
    }

    protected List<ResponseInbodyDto> inbodyListToResponseInbodyDtoList(List<Inbody> list) {
        if ( list == null ) {
            return null;
        }

        List<ResponseInbodyDto> list1 = new ArrayList<ResponseInbodyDto>( list.size() );
        for ( Inbody inbody : list ) {
            list1.add( inbodyToResponseInbodyDto( inbody ) );
        }

        return list1;
    }
}
