package HealthCare.trainer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;

    @Column(nullable = false)
    private String trainerName;

    @Column(nullable = false)
    private String trainerPassWord;

    @Column(nullable = false)
    private String trainerEmail;

    @Column(nullable = false)
    private String trainerPhone;

    @Column(nullable = false)
    private LocalDate trainerSignUp;


    /////////////////////////////////////
    // mapping

}
