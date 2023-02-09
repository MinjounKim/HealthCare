package HealthCare.trainer.dto;

import HealthCare.member.dto.MemberResponseDto;
import HealthCare.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class TrainerResponseDto {

    private String trainerName;

    private String trainerEmail;

    private String trainerPhone;

    private List<MemberResponseDto> members;
}
