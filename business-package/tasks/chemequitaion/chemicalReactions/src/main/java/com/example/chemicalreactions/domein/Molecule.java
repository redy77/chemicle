package com.example.chemicalreactions.domein;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

//класс молекулы
@Entity
@Table(name = "molecules")
@Data //заменяет все сеттеры и геттеры
@NoArgsConstructor
@AllArgsConstructor
public class Molecule {

    @Id
    @Column(name = "chemical_formula_Molecule") //химическая формула, так же является айдишником
    private String chemicalFormulaMolecule; //формула молекулы в виде строки (например H2CO3)

    @Column(name = "name_molecule")
    private String nameMolecule; //имя молекулы (например карбоновая кислота)

//    @OneToMany //(cascade = CascadeType.ALL)
//    @ElementCollection
//    private Map<Atom, Integer> moleculeComposition; //состав молекулы Атом и его количество

    @Override
    public String toString() {
        return "Молекула " + nameMolecule + "\n" +
                "Химическая формула " + chemicalFormulaMolecule;
    }
}
