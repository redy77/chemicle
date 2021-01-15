package com.chemcool.school.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chemistry_equation_task")
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryEquationTask implements ChemistryTask {

    @Id
    @Column(name = "chemistry_equation_task_uuid")
    private String chemistryEquationTaskUuid;

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

    @Column(name = "wrong_products1")
    private String wrongProducts1;

    @Column(name = "wrong_products2")
    private String wrongProducts2;

    @Column(name = "wrong_products3")
    private String wrongProducts3;

}
