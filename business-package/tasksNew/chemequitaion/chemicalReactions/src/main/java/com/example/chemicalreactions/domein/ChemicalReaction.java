package com.example.chemicalreactions.domein;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

//класс химической реакции
@Entity
@Table(name = "chemical_reaction")
@Data //заменяет все сеттеры и геттеры
@NoArgsConstructor
@AllArgsConstructor
public class ChemicalReaction {

    @Id
    @Column(name = "string_chemical_reaction")
    private String stringChemicalReaction; //строка химической реакции

    @Column(name = "name_chemical_reaction")
    private String nameChemicalReaction; //название химической реакции

    @Column(name = "types_of_reaction")
    private String typesOfReaction; //тип реакции

//    @Column(name = "reagents")
//    private String reagents; //реагенты - кто вступают в реакцию. Молекулы и количество
//
//    @Column(name = "reaction_products")
//    private String reactionProducts; //продукты реакции. Молекулы и количество

//    @ElementCollection
//    private Map<Molecule, Integer> reagents; //реагенты - кто вступают в реакцию. Молекулы и количество
//
    @ElementCollection
    private Map<Molecule, Integer> productsReakcii; //продукты реакции. Молекулы и количество

}
