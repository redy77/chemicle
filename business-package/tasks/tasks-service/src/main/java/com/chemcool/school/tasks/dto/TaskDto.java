package com.chemcool.school.tasks.dto;

import com.chemcool.school.tasks.domain.CoupleForMatchingTask;
import com.chemcool.school.tasks.domain.TypeOfTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private String id;
    private String description;
    private String chapterId;
    private TypeOfTask typeOfTask;
    private List<CoupleForMatchingTask> coupleForMatchingTasks;
}