package com.chemcool.school.tasks.chemequations.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chemistry_base_compound")
public class ChemBaseCompound {

    @Id
    @Column(name = "element_id")
    private String baseCompoundId;

    @Column(name = "base_compound_symbols")
    private String baseCompoundSymbols;

    @Type(type = "jsonb")
    @Column (name = "base_compound_elements", columnDefinition = "jsonb")
    private Set<ChemElement> baseCompoundElements;

    @Column(name = "base_compound_name")
    private String baseCompoundName;

    public static ChemBaseCompound createChemBaseCompound
            (
            ChemCompound compound, String compoundName
    ){
        return new ChemBaseCompound(
                UUID.randomUUID().toString(),
                compound.getCompoundSymbols(),
                compound.getCompoundElements(),
                compoundName
        );
    }
}
