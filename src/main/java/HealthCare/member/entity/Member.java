package HealthCare.member.entity;

import HealthCare.attendance.entity.Attendance;
import HealthCare.inbody.entity.Inbody;
import HealthCare.trainer.entity.Trainer;
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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String memberPassWord;

    @Column(nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String memberPhone;

    @Column(nullable = false)
    private Long attendanceCount;

    @Column(nullable = false)
    private LocalDate memberSignUp;

    private Long trainerId;

    /////////////////////////////////////
    // mapping

    @OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST)
    private List<Attendance> attendances=new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST)
    private List<Inbody> inbodies=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "trainerId",insertable = false,updatable = false)
    private Trainer trainer;

}
