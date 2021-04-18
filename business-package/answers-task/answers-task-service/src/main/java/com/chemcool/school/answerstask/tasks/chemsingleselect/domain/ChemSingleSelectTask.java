package com.chemcool.school.answerstask.tasks.chemsingleselect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemSingleSelectTask {
    private String taskId;
    private String description;
    private String correctAnswer;
    private int chapterId;
    private int referenceId;
    private String incorrectAnswerOne;
    private String incorrectAnswerTwo;
    private String incorrectAnswerThree;
    private String incorrectAnswerFour;
}
