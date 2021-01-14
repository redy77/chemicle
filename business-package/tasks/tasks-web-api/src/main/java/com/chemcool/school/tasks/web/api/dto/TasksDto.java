package com.chemcool.school.tasks.web.api.dto;

import com.chemcool.school.tasks.domain.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TasksDto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "right_products")
    private String rightProducts;

    @Column(name = "chapter_id")
    private String chapterId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_task")
    private TypeOfTask typeOfTask;

    @Column(name = "reagents")
    private String reagents;

    @Column(name = "wrong_products_1")
    private String wrongProducts1;

    @Column(name = "wrong_products_2")
    private String wrongProducts2;

    @Column(name = "wrong_products_3")
    private String wrongProducts3;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<CoupleForMatchingTask> coupleForMatchingTasks;



    public Optional<TypeOfTask> getTypeOfTask() {
        return Optional.ofNullable(typeOfTask);
    }
}
