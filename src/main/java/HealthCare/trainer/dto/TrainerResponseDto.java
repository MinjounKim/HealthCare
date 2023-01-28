package HealthCare.trainer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class TrainerResponseDto {

    private String trainerName;

    private String trainerEmail;

    private String trainerPhone;
}
