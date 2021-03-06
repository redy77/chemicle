package com.chemcool.school.answerstask.tasks.chemmatches.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "correct_couples_for_matching")
public class CoupleForMatching implements Comparable<CoupleForMatching>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coupleId;

    @Column(name = "left_couple")
    private String leftCouple;

    @Column(name = "right_couple")
    private String rightCouple;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoupleForMatching that = (CoupleForMatching) o;
        return leftCouple.equals(that.leftCouple) && rightCouple.equals(that.rightCouple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftCouple, rightCouple);
    }

    @Override
    public int compareTo(CoupleForMatching coupleForMatching) {
        return this.getLeftCouple().compareTo(coupleForMatching.getLeftCouple());
    }
}
