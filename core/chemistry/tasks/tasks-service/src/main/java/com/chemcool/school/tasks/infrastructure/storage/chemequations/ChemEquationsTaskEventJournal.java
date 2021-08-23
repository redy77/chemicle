package com.chemcool.school.tasks.infrastructure.storage.chemequations;

import com.chemcool.school.tasks.domain.chemequations.ChemEquationsTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemEquationsTaskEventJournal
        extends JpaRepository<ChemEquationsTaskEvent, String> {
}
