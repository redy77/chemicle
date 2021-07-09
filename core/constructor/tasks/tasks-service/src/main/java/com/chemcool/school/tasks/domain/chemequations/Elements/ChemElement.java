package com.chemcool.school.tasks.domain.chemequations.Elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chemistry_element")
public class ChemElement {

    @Id
    @Column(name = "element_id")
    private String elementId;

    @Column(name = "element_number")
    private int elementNumber;

    @Column(name = "element_symbol")
    private String elementSymbol;

    @Column(name = "element_transcription")
    private String ElementTranscription;

    @Column(name = "element_name")
    private String elementName;

    @Column(name = "element_lat_name")
    private String elementLatName;

    @Column(name = "element_molar_mass")
    private double elementMolarMass;

    @Column(name = "element_oxidation_value")
    private String elementOxidationValue;

    @Column(name = "element_period")
    private String elementPeriod;

    @Column(name = "element_group")
    private int elementGroup;

    @Column(name = "element_subgroup")
    private String elementSubgroup;

    @Column(name = "element_valence")
    private String elementValence;


    public int getElementLowValence() {
        return 8 - elementGroup;
    }

    public int getElementHighValence() {
        return elementGroup;
    }

    public String getElementValence() {
        if (elementValence.contains("-1")) {
            int val = elementGroup > 4 ? getElementLowValence() : getElementHighValence();
            return String.valueOf(val);
        }
        return elementValence;
    }
}
