package com.chemcool.school.answerstask.tasks.chemmatches.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "correct_couples_for_matching")
public class CoupleForMatching {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coupleId;

    @Column(name = "left_couple")
    private String leftCouple;

    @Column(name = "right_couple")
    private String rightCouple;
}
