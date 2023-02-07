package HealthCare.inbody.dto;

import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostInbodyDto {

    @Column(nullable = true)
    private Long arms;

    @Column(nullable = true)
    private Long legs;

    @Column(nullable = true)
    private Long body;


}
