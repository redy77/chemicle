package com.chemcool.school.tasks.web.api.dto;

import com.chemcool.school.tasks.domain.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class TasksDto {

    //Одинаковые поля для всех классов task
    private String id;
    private String description;
    private String rightAnswer; //Нет в классе сопоставления
    private String chapterId;
    private TypeOfTask typeOfTask;

    //Уникальные поля в сущностях task
    private String rightProducts;

    private String reagents;

    private String wrongProducts1;
    private String wrongProducts2;
    private String wrongProducts3;

    private String incorrectAnswer1;
    private String incorrectAnswer2;
    private String incorrectAnswer3;

    private List<CoupleForMatching> coupleForMatchings;

    public TasksDto(String id, String description, String rightAnswer, String chapterId, TypeOfTask typeOfTask) {
        this.id = id;
        this.description = description;
        this.rightAnswer = rightAnswer;
        this.chapterId = chapterId;
        this.typeOfTask = typeOfTask;
    }

    public TasksDto(FixedAnswerTask task) {
        this(
                task.getId(),
                task.getDescription(),
                task.getRightAnswer(),
                task.getChapterId(),
                task.getTypeOfTask()
        );
    }

    public TasksDto(ChemistryEquationTask task) {
        this(
                task.getId(),
                task.getDescription(),
                null,
                task.getChapterId(),
                task.getTypeOfTask()
        );
        this.rightProducts = task.getRightProducts();
        this.reagents = task.getReagents();
        this.wrongProducts1 = task.getWrongProducts1();
        this.wrongProducts2 = task.getWrongProducts2();
        this.wrongProducts3 = task.getWrongProducts3();
    }

    public TasksDto(MatchingOfTwoSidesTask task) {
        this(
                task.getId(),
                task.getDescription(),
                null,
                task.getChapterId(),
                task.getTypeOfTask()
        );
        this.coupleForMatchings = coupleForMatchings;
    }

    public TasksDto(SingleSelectQuestionTask task) {
        this(
                task.getId(),
                task.getDescription(),
                task.getRightAnswer(),
                task.getChapterId(),
                task.getTypeOfTask()
        );
        this.incorrectAnswer1 = task.getIncorrectAnswer1();
        this.incorrectAnswer2 = task.getIncorrectAnswer2();
        this.incorrectAnswer3 = task.getIncorrectAnswer3();
    }

    public Optional<TypeOfTask> getTypeOfTask() {
        return Optional.ofNullable(typeOfTask);
    }
}
