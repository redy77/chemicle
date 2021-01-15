package com.chemcool.school.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fixed_answer")
public class ChemistryFixedAnswerTask implements ChemistryTask {

    @Id
    private String id;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "right_answer")
    @NonNull
    private String rightAnswer;

    @Column(name = "chapter_id")
    @NonNull
    private String chapterId;

    @Column(name = "type_of_task")
    @Enumerated(EnumType.STRING)
    @NonNull
    private TypeOfTask typeOfTask;
}
