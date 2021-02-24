package com.chemcool.school.tasks.chemequations.domain;

import com.chemcool.school.tasks.chemequations.exception.ChemEquationsTaskException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


/**
 * Класс для построения химических соединений
 *
 * @version 1.0
 * @autor Евгений Жиленков
 */
@Data
@AllArgsConstructor
public class ChemCompound {

    private String compoundSymbols;
    private Map<ChemElement, Integer> compoundElements;

    public ChemCompound() {
        this.compoundElements = new HashMap();
        this.compoundSymbols = "";
    }

    public boolean checkFactors(Map<ChemElement, Integer> elementsMap) {

        return true;
    }

    public String checkFactorsTest(Map<ChemElement, Integer> elementsMap) {
        ChemElement bufElement = null;
        if(elementsMap.size()<=2) {
            for (ChemElement el : elementsMap.keySet()) {
                if (bufElement == null) {
                    bufElement = el;
                    continue;
                }

                System.err.println(elementsMap.get(el).toString());
                if (elementsMap.get(el) == bufElement.getElementValence() && elementsMap.get(bufElement) == el.getElementValence())
                    return "true";
            }
            return "false";
        }
        return "bigFalse";
    }

    public void reaction(List<ChemElement> elements) {
//        for (ChemElement el : elements) {
//            if (!compoundElements.containsKey(el)){
//                compoundElements.put(el,1);
//
//            }else {
//                compoundElements.put(el,compoundElements.get(el)+1);
//            }
//        }
        elements.stream().forEach(e -> compoundElements.put(e, compoundElements.getOrDefault(e, 0) + 1));
        if (checkFactors(compoundElements)) {
            reactionWrite();
        } else {
            throw new ChemEquationsTaskException("Ошибка условий формарования молекулы");
        }
        //betaTest
        System.out.println(checkFactorsTest(compoundElements));
    }

    public void reactionWrite() {
        compoundElements.keySet().stream().forEach(e -> compoundSymbols += e.getElementSymbol() + compoundElements.get(e));
        compoundSymbols = compoundSymbols.replaceAll("1", "");
    }
}
