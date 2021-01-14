package com.chemcool.school.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table("chemistry_equation_task")
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryEquationTask implements ChemistryTask {

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
    @Column(name = "type_of_tasks")
    private TypeOfTask typeOfTask;

    @Column(name = "reagents")
    private String reagents;

    @Column(name = "wrong_products_1")
    private String wrongProducts1;

    @Column(name = "wrong_products_2")
    private String wrongProducts2;

    @Column(name = "wrong_products_3")
    private String wrongProducts3;

}
