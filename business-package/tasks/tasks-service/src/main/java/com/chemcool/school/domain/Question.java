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
public class Question {

    @Id
    private String id;

    @Column(name = "question")
    private String question;

    @OneToOne(mappedBy = "questionId")
    private Collate collateByQuestion;
}
