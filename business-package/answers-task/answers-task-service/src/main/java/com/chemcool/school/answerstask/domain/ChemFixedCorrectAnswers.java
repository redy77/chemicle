package com.chemcool.school.answerstask.domain;

import com.chemcool.school.answerstask.tasks.chemequitation.domain.ChemEquationsTask;
import com.chemcool.school.answerstask.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
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
@Table(name = "chemfixed_correct_answers")
public class ChemFixedCorrectAnswers {
    @Id
    @Column(name = "task_id")
    String id;

    @Column(name = "correct_answer")
    String correctAnswer;

    public static ChemFixedCorrectAnswers createChemFixedCorrectAnswers(ChemFixedAnswerTask task) {
        return new ChemFixedCorrectAnswers(task.getTaskId(), task.getRightAnswer());
    }
}
