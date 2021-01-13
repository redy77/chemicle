package com.chemcool.school.tasks.domain.fixedanswer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fixedAnswer")
public class FixedAnswer {

    public static FixedAnswer getInstance() {
        return new FixedAnswer();
    }

    @Id
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "rightAnswer")
    private String rightAnswer;

    @Column(name = "numberOfChapter")
    private int numberOfChapter;

    @Column(name = "typeOfTasks")
    private TypeOfTask typeOfTasks;
}
