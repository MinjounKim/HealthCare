package HealthCare.trainer.entity;

import HealthCare.inbody.entity.Inbody;
import HealthCare.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "trainer",cascade = CascadeType.PERSIST)
    private List<Member> members=new ArrayList<>();


}
