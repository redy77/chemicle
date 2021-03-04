package com.chemcool.school.answerstask.tasks.chemequitation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChemEquationsTask {
    private String taskId;
    private String description;
    private String rightAnswer;
    private int chapterId;
    private int referenceId;

}