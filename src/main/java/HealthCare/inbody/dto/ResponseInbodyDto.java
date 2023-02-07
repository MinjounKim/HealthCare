package HealthCare.inbody.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ResponseInbodyDto {

    private Long inbodyId;

    private Long memberId;

    private String memberName;

    private LocalDate measurementDate;

    private Long arms;

    private Long legs;

    private Long body;
}
