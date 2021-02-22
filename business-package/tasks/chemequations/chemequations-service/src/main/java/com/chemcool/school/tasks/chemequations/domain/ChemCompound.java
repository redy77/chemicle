package com.chemcool.school.tasks.chemequations.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemCompound {

    private String compoundSymbols;
    private Set<ChemElement> compoundElements;

    public void reaction(ChemElement firstElement, ChemElement secondElement){
        compoundElements.addAll(Collections.emptyList());
        compoundSymbols = firstElement.getElementSymbol()+secondElement.getElementSymbol();
    }
}
