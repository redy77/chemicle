package com.chemcool.school.tasks.chemequations.storage;

import com.chemcool.school.tasks.chemequations.domain.ChemCompoundEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChemEquationsTaskEventJournal
        extends JpaRepository<ChemCompoundEvent, String> {
}
