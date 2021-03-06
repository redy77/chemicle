package com.chemcool.school.answerstask.web.api.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class AbstractBaseCorrectAnswersClass {

    @Id
    @Column(name = "task_id")
    String id;

    @Column(name = "correct_answer")
    String correctAnswer;
}
