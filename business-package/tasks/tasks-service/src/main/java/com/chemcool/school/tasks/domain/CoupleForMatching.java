package com.chemcool.school.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "couples")
public class CoupleForMatching {

    @Id
    private String id;

    @Column(name = "left_couple")
    private String leftCouple;

    @Column(name = "right_couple")
    private String rightCouple;

}
