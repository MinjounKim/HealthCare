package HealthCare.trainer.mapper;

import HealthCare.attendance.dto.ResponseAttendanceDto;
import HealthCare.attendance.entity.Attendance;
import HealthCare.inbody.dto.ResponseInbodyDto;
import HealthCare.inbody.entity.Inbody;
import HealthCare.member.dto.MemberResponseDto;
import HealthCare.member.entity.Member;
import HealthCare.trainer.dto.TrainerPatchDto;
import HealthCare.trainer.dto.TrainerPostDto;
import HealthCare.trainer.dto.TrainerResponseDto;
import HealthCare.trainer.entity.Trainer;
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
public class TrainerMapperImpl implements TrainerMapper {

    @Override
    public Trainer TrainerPostDtoToTrainer(TrainerPostDto trainerPostDto) {
        if ( trainerPostDto == null ) {
            return null;
        }

        Trainer trainer = new Trainer();

        trainer.setTrainerName( trainerPostDto.getTrainerName() );
        trainer.setTrainerPassWord( trainerPostDto.getTrainerPassWord() );
        trainer.setTrainerEmail( trainerPostDto.getTrainerEmail() );
        trainer.setTrainerPhone( trainerPostDto.getTrainerPhone() );

        return trainer;
    }

    @Override
    public TrainerResponseDto TrainerToTrainerResponseDto(Trainer trainer) {
        if ( trainer == null ) {
            return null;
        }

        TrainerResponseDto.TrainerResponseDtoBuilder trainerResponseDto = TrainerResponseDto.builder();

        trainerResponseDto.trainerName( trainer.getTrainerName() );
        trainerResponseDto.trainerEmail( trainer.getTrainerEmail() );
        trainerResponseDto.trainerPhone( trainer.getTrainerPhone() );
        trainerResponseDto.members( memberListToMemberResponseDtoList( trainer.getMembers() ) );

        return trainerResponseDto.build();
    }

    @Override
    public Trainer TrainerPatchDtoToTrainer(TrainerPatchDto trainerPatchDto) {
        if ( trainerPatchDto == null ) {
            return null;
        }

        Trainer trainer = new Trainer();

        trainer.setTrainerName( trainerPatchDto.getTrainerName() );
        trainer.setTrainerPassWord( trainerPatchDto.getTrainerPassWord() );
        trainer.setTrainerEmail( trainerPatchDto.getTrainerEmail() );
        trainer.setTrainerPhone( trainerPatchDto.getTrainerPhone() );

        return trainer;
    }

    @Override
    public List<TrainerResponseDto> TrainersToTrainerResponseDtos(List<Trainer> trainers) {
        if ( trainers == null ) {
            return null;
        }

        List<TrainerResponseDto> list = new ArrayList<TrainerResponseDto>( trainers.size() );
        for ( Trainer trainer : trainers ) {
            list.add( TrainerToTrainerResponseDto( trainer ) );
        }

        return list;
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

    protected MemberResponseDto memberToMemberResponseDto(Member member) {
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

    protected List<MemberResponseDto> memberListToMemberResponseDtoList(List<Member> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberResponseDto> list1 = new ArrayList<MemberResponseDto>( list.size() );
        for ( Member member : list ) {
            list1.add( memberToMemberResponseDto( member ) );
        }

        return list1;
    }
}
