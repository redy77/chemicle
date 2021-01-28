package com.chemcool.school.chemmatches.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "couples_for_matching")
public class CoupleForMatching {

    @Id
    @Column(name = "couple_for_matching_uuid", unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String coupleForMatchingUuid;

    @Column(name = "left_couple")
    private String leftCouple;

    @Column(name = "right_couple")
    private String rightCouple;

}