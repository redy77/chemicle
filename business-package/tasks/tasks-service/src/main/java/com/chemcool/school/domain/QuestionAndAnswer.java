package com.chemcool.school.domain;

import javax.persistence.*;

@Entity
public class QuestionAndAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "questions")
    private String questions;

    @OneToOne(mappedBy = "questionId")
    private Collate connectionOfQuestion;

    @OneToOne(mappedBy = "answerId")
    private Collate connectionOfAnswer;

    public QuestionAndAnswer() {
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

    public Collate getConnectionOfQuestion() {
        return connectionOfQuestion;
    }

    public void setConnectionOfQuestion(Collate connectionOfQuestion) {
        this.connectionOfQuestion = connectionOfQuestion;
    }

    public Collate getConnectionOfAnswer() {
        return connectionOfAnswer;
    }

    public void setConnectionOfAnswer(Collate connectionOfAnswer) {
        this.connectionOfAnswer = connectionOfAnswer;
    }
}
