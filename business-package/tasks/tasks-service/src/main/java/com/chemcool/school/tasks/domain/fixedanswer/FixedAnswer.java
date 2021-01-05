package com.chemcool.school.tasks.domain.fixedanswer;

import javax.persistence.*;

@Entity
@Table(name = "fixedAnswer")
public class FixedAnswer {

    @Id
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "rightAnswer")
    private String rightAnswer;

    @Column(name = "numberOfChapter")
    private int numberOfChapter;

    @Column(name = "typeOfTasks")
    private Enum typeOfTasks;

    public FixedAnswer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public int getNumberOfChapter() {
        return numberOfChapter;
    }

    public void setNumberOfChapter(int numberOfChapter) {
        this.numberOfChapter = numberOfChapter;
    }

    public Enum getTypeOfTasks() {
        return typeOfTasks;
    }

    public void setTypeOfTasks(Enum typeOfTasks) {
        this.typeOfTasks = typeOfTasks;
    }
}
