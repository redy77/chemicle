package com.chemcool.school.tasks.domain;

import com.chemcool.school.tasks.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matching_task_of_two_sides")
public class MatchingTaskOfTwoSides {

    @Id
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "chapter_id")
    private String chapterId;

    @Column(name = "type_of_task")
    private TypeOfTask typeOfTask;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<CoupleForMatchingTask> coupleForMatchingTasks;

    public MatchingTaskOfTwoSides(TaskDto dto) {
        this.id = dto.getId();
        this.description = dto.getDescription();
        this.chapterId = dto.getChapterId();
        this.typeOfTask = dto.getTypeOfTask();
        this.coupleForMatchingTasks = dto.getCoupleForMatchingTasks();
    }
}
