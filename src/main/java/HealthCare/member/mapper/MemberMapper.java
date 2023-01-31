package HealthCare.member.mapper;

import HealthCare.member.dto.MemberPatchDto;
import HealthCare.member.dto.MemberPostDto;
import HealthCare.member.dto.MemberResponseDto;
import HealthCare.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoTomember(MemberPostDto memberPostDto);

    MemberResponseDto memberTomemberResponseDto(Member member);

    Member memberPatchDtoTomember(MemberPatchDto memberPatchDto);

    List<MemberResponseDto> membersTomemberResponseDtos(List<Member> members);
}
