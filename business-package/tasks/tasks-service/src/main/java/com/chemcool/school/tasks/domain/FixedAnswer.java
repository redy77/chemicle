package com.chemcool.school.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fixed_answer")
public class FixedAnswer {

    @Id
    private String id;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "right_answer")
    @NonNull
    private String rightAnswer;

    @Column(name = "chapter_id")
    @NonNull
    private int numberOfChapter;

    @Column(name = "type_of_task")
    @Enumerated(EnumType.STRING)
    @NonNull
    private TypeOfTask typeOfTask;

    public static FixedAnswer createFixedAnswer(FixedAnswer fixedAnswer){
        return new FixedAnswer(
                UUID.randomUUID().toString(),
                fixedAnswer.getDescription(),
                fixedAnswer.getRightAnswer(),
                fixedAnswer.getNumberOfChapter(),
                fixedAnswer.getTypeOfTask()
        );

    }
}
