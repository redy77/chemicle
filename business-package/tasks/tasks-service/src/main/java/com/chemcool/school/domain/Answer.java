package com.chemcool.school.domain;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "answers")
    private String answers;

    @OneToOne(mappedBy = "answerId")
    private Collate collateByAnswer;

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Collate getCollateByAnswer() {
        return collateByAnswer;
    }

    public void setCollateByAnswer(Collate collateByAnswer) {
        this.collateByAnswer = collateByAnswer;
    }
}
