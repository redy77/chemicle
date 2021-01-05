package com.chemcool.school.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Answer {

    @Id
    private String id;

    @Column(name = "answer")
    private String answer;

    @OneToOne(mappedBy = "answerId")
    private Collate collateByAnswer;
}
