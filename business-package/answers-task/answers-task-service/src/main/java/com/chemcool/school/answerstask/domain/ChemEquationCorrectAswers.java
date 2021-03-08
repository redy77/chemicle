package com.chemcool.school.answerstask.domain;

import com.chemcool.school.answerstask.tasks.chemequation.domain.ChemEquationsTask;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "chem_equation_correct_answers")
public class ChemEquationCorrectAswers extends AbstractBaseCorrectAnswersClass{

    public ChemEquationCorrectAswers(String taskId, String rightAnswer) {
        super(taskId, rightAnswer);
    }

    public static ChemEquationCorrectAswers createChemequitationСorrectAnswers(ChemEquationsTask task) {
        return new ChemEquationCorrectAswers(task.getTaskId(), task.getRightAnswer());
    }
}
