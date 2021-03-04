package com.chemcool.school.answerstask.domain;

import com.chemcool.school.answerstask.tasks.chemequitation.domain.ChemEquationsTask;
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
@Table(name = "cmemequitation_correct_answers")
public class ChemequitationСorrectAnswers {

    @Id
    @Column(name = "task_id")
    String id;

    @Column(name = "correct_answer")
    String correctAnswer;

    public static ChemequitationСorrectAnswers createChemequitationСorrectAnswers(ChemEquationsTask task) {
        return new ChemequitationСorrectAnswers(task.getTaskId(), task.getRightAnswer());
    }
}
