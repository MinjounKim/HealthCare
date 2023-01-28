package HealthCare.trainer.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class TrainerPostDto {

    private String trainerName;

    private String trainerPassWord;

    private String trainerEmail;

    private String trainerPhone;

}
