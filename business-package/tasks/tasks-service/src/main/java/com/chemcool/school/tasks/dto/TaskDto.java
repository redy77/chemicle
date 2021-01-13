package com.chemcool.school.tasks.dto;

import com.chemcool.school.tasks.domain.TypeOfTask;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDto {
    private String UUID;
    private String description;
    private String rightProducts;
    private String chapterId;
    private TypeOfTask typeOfTask;
    private String reagents;
    private String wrongProducts1;
    private String wrongProducts2;
    private String wrongProducts3;
}
