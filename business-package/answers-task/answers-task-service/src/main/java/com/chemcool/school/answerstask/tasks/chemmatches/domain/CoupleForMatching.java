package com.chemcool.school.answerstask.tasks.chemmatches.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class CoupleForMatching {
    private Long coupleId;
    private String leftCouple;
    private String rightCouple;
}