package com.chemcool.school.answerstask.web.api.domain;

import com.chemcool.school.answerstask.tasks.chemsingleselect.domain.ChemSingleSelectTask;
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
@Table(name = "cmemesingleselect_correct_answers")
public class ChemSingleSelectCorrectAnswers {
    @Id
    @Column(name = "task_id")
    String id;

    @Column(name = "correct_answer")
    String correctAnswer;

    public static ChemSingleSelectCorrectAnswers createChemSingleSelectCorrectAnswers(ChemSingleSelectTask task) {
        return new ChemSingleSelectCorrectAnswers(task.getTaskId(), task.getCorrectAnswer());
    }
}
