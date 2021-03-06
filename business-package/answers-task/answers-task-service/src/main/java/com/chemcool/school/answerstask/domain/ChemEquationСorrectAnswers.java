package com.chemcool.school.answerstask.domain;

import com.chemcool.school.answerstask.tasks.chemequation.domain.ChemEquationsTask;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "cmem_equation_correct_answers")
public class ChemEquationСorrectAnswers extends AbstractBaseCorrectAnswersClass{

    public ChemEquationСorrectAnswers(String taskId, String rightAnswer) {
        super(taskId, rightAnswer);
    }

    public static ChemEquationСorrectAnswers createChemequitationСorrectAnswers(ChemEquationsTask task) {
        return new ChemEquationСorrectAnswers(task.getTaskId(), task.getRightAnswer());
    }
}
