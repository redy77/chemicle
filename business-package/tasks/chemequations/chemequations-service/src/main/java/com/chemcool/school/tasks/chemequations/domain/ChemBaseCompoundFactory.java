package com.chemcool.school.tasks.chemequations.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemBaseCompoundFactory {
    public static ChemBaseCompound createBaseCompound(ChemCompound compound, String compoundName){
        log.info("Попытка создать базовое химическое соединение");
        return ChemBaseCompound.createChemBaseCompound(compound,compoundName);
    }
}
