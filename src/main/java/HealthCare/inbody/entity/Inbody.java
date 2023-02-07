package HealthCare.inbody.entity;

import HealthCare.member.entity.Member;
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
public class Inbody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inbodyId;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private LocalDate measurementDate;

    @Column(nullable = true)
    private Long arms;

    @Column(nullable = true)
    private Long legs;

    @Column(nullable = true)
    private Long body;
    /////////////////////////////////////
    // mapping

    @ManyToOne
    @JoinColumn(name = "memberId",insertable = false,updatable = false)
    private Member member;

}
