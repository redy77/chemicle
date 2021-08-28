package com.chemcool.school.constructor.domain.base;

import com.chemcool.school.constructor.domain.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TaskBaseClass {
    @Id
    @Column(name = "task_id")
    private String taskId;

    @Column(name = "condition_of_task")
    @NonNull
    private Integer conditionOfTask;

    @Column(name = "class_num")
    @NonNull
    private Integer classNum;

    @Column(name = "chapter_num")
    @NonNull
    private Integer chapterNum;

    @Column(name = "paragraph_num")
    @NonNull
    private Integer paragraphNum;

    @Column(name = "task_status")
    @NonNull
    private TaskStatus taskStatus;

    @Column(name = "is_hidden", columnDefinition = "boolean default false")
    private Boolean isHidden;
}
