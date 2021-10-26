package com.chemcool.school.constructor.domain;

import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "comparison")
@RequiredArgsConstructor
public class Comparison extends Task {

    @Column
    @NonNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<ComparisonPair> comparisonPairs;

    @Builder
    public Comparison(String taskId, String conditionOfTask, Short classNum, Short chapterNum,
                            Short paragraphNum, TaskStatus status, TaskType type, Boolean isHidden,
                            List<ComparisonPair> comparisonPairs) {
        super(taskId, conditionOfTask, classNum, chapterNum, paragraphNum, status, type, isHidden);
        this.comparisonPairs = comparisonPairs;
    }
}
