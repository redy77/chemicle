package com.chemcool.school.tasks.chemequations.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity химического элемента
 *
 * @version 1.0
 * @autor Евгений Жиленков
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chemistry_element")
public class ChemElement {

    //id элемента в бд
    @Id
    @Column(name = "element_id")
    private String elementId;

    //порядковый номер элемента - это число равное числу протонов в ядре атома и числу электронов,
    //которые вращаются вокруг него
    @Column(name = "element_number")
    private  int elementNumber;

    //символ элемента
    @Column(name = "element_symbol")
    private String elementSymbol;

    //наименование элемента
    @Column(name = "element_name")
    private String elementName;

    @Column(name = "element_molar_mass")
    private double elementMolarMass;

    //Периоды  –  горизонтальные строки химических элементов
    //Номер периода  –  номер внешнего энергетического уровня в электронной формуле атома элемента
    @Column(name = "element_period")
    private String elementPeriod;

    //Группы - вертикальные строки химических элементов
    //Номер группы (для большинства элементов)  –  общее число валентных электронов
    // (электронов внешнего энергетического уровня, а также предпоследнего d-подуровня,
    // если он застроен не полностью)
    @Column(name = "element_group")
    private String elementGroup;

    //Подгруппа - А - главные (s- и р-элементы) и В - побочные (d- и f-элементы)
    @Column(name = "element_subgroup")
    private String elementSubgroup;


}
