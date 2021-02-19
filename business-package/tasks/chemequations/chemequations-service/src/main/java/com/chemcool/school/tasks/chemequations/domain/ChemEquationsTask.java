package com.chemcool.school.tasks.chemequations.domain;

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
@Entity
@Table(name = "chemistry_equations")
public class ChemEquationsTask {

    @Id
    @Column(name = "task_id")
    private String taskId;

//    описание задания
    @Column(name = "description", length = 10000)
    private String description;

//  уравнение
    @Column(name = "equations")
    private String equations;

//    правильный ответ
    @Column(name = "right_answer")
    @NonNull
    private String rightAnswer;

//  id главы
    @Column(name = "chapter_id")
    @NonNull
    private int chapterId;

//  id раздела
    @Column(name = "reference_id")
    @NonNull
    private int referenceId;

    public static ChemEquationsTask createChemEquationsTask(
            ChemEquationsTaskExample task
    ){
        return new ChemEquationsTask(
                UUID.randomUUID().toString(),
                task.getDescription(),
                task.getEquations(),
                task.getRightAnswer(),
                task.getChapterId(),
                task.getReferenceId()
        );
    }
}
