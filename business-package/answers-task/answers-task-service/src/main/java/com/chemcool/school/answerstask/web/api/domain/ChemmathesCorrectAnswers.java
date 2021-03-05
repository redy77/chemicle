package com.chemcool.school.answerstask.web.api.domain;

import com.chemcool.school.answerstask.tasks.chemmatches.domain.ChemistryMatchingTask;
import com.chemcool.school.answerstask.tasks.chemmatches.domain.CoupleForMatching;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chemmathes_correct_answers")
public class ChemmathesCorrectAnswers {
    @Id
    @Column(name = "task_id")
    String id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private List<CoupleForMatching> correctCoupleForMatchingList;

    public static ChemmathesCorrectAnswers createChemmathesCorrectAnswers(ChemistryMatchingTask task) {
        return new ChemmathesCorrectAnswers(task.getTaskId(), task.getCoupleForMatchingList());
    }
}
