package HealthCare.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class MemberResponseDto {

    private String memberName;

    private String memberEmail;

    private String memberPhone;
}
