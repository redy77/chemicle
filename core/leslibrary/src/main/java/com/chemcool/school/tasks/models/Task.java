package com.chemcool.school.tasks.models;

import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Task {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
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

    @Column(name = "task_type")
    @NonNull
    @Enumerated(EnumType.STRING)
    private TaskType taskType;

    @Column(name = "is_hidden", columnDefinition = "boolean default false")
    private Boolean isHidden;
}