package com.chemcool.school.tasks.chemequations.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemCompound {

    private String compoundSymbols;
    private Map<ChemElement,Integer> compoundElements;

    public boolean reaction(ChemElement ... elements){
        if(compoundElements==null){
            compoundElements = new HashMap();
        }
        for (ChemElement el : elements) {
            if (!compoundElements.containsKey(el)){
                compoundElements.put(el,1);

            }else {
                compoundElements.put(el,compoundElements.get(el)+1);
            }
        }
        compoundSymbols = compoundElements.toString();
        return true;
    }
}
