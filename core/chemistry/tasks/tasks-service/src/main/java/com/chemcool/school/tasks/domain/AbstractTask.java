package com.chemcool.school.tasks.domain;

import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * @Author : Constantine Lee
 * @Date : 27.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "task")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "task_type")
public abstract class AbstractTask {

    @Id
    @Column(name = "task_id")
    private String taskId;

    @Column(name = "condition_of_task")
    @NonNull
    private String conditionOfTask;

    @Column(name = "class_num")
    @NonNull
    private Short classNum;

    @Column(name = "chapter_num")
    @NonNull
    private Short chapterNum;

    @Column(name = "paragraph_num")
    @NonNull
    private Short paragraphNum;

    @Column(name = "task_status")
    @NonNull
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Column(name = "task_type", insertable = false, updatable = false)
    @NonNull
    @Enumerated(EnumType.STRING)
    private TaskType taskType;

    @Column(name = "is_hidden", columnDefinition = "boolean default false")
    private Boolean isHidden;

    @Column(name = "task_number")
    private Integer taskNumber;
}
