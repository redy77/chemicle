package com.chemcool.school.domain;

import javax.persistence.*;

@Entity
public class Collate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private QuestionAndAnswer questionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    private QuestionAndAnswer answerId;

//    @OneToMany(mappedBy="chapterId")
//    private Set<Chapter> chapterSet;

    public Collate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionAndAnswer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(QuestionAndAnswer questionId) {
        this.questionId = questionId;
    }

    public QuestionAndAnswer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(QuestionAndAnswer answerId) {
        this.answerId = answerId;
    }
}
