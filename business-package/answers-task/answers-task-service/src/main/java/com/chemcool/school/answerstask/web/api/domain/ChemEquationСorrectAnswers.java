package com.chemcool.school.answerstask.web.api.domain;

import com.chemcool.school.answerstask.tasks.chemequation.domain.ChemEquationsTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cmem_equation_correct_answers")
public class ChemEquationСorrectAnswers {

    @Id
    @Column(name = "task_id")
    String id;

    @Column(name = "correct_answer")
    String correctAnswer;

    public static ChemEquationСorrectAnswers createChemequitationСorrectAnswers(ChemEquationsTask task) {
        return new ChemEquationСorrectAnswers(task.getTaskId(), task.getRightAnswer());
    }
}
