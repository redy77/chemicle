package com.chemcool.school.tasks.chemequations.storage;

import com.chemcool.school.tasks.chemequations.domain.ChemBaseCompound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemBaseCompoundRepository
        extends JpaRepository<ChemBaseCompound,String>, JpaSpecificationExecutor<ChemBaseCompound> {

}
