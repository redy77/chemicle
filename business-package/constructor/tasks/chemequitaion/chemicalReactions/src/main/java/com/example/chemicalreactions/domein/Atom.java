package com.example.chemicalreactions.domein;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity //указывает, что данный бин (класс) является сущностью.
@Table(name = "atoms") //указывает на имя таблицы, которая будет отображаться в этой сущности.
@Data //заменяет все сеттеры и геттеры
@NoArgsConstructor
@AllArgsConstructor
public class Atom {

    @Id
    @Column(name = "symbol")
    private String symbol; //символ элемента в таблице Менделлева

    @Column(name = "name") //указывает на имя колонки, которая отображается в свойство сущности.
    private String name; //имя элемента

    @Column(name = "number_atoma")
    private int numberAtoma; //порядковый номер в таблице менделеева (на данный момент известно 118 элементов)

    @Column(name = "atomic_mass")
    private double atomicMass; //атомная масса
}

