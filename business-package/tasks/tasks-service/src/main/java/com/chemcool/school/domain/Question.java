package com.chemcool.school.domain;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "questions")
    private String questions;

    @OneToOne(mappedBy = "questionId")
    private Collate collateByQuestion;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questonAndAnswer) {
        this.questions = questonAndAnswer;
    }

    public Collate getCollateByQuestion() {
        return collateByQuestion;
    }

    public void setCollateByQuestion(Collate collateByQuestion) {
        this.collateByQuestion = collateByQuestion;
    }
}
