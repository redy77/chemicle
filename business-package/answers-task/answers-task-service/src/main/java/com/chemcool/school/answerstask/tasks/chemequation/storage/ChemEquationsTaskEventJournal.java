package com.chemcool.school.answerstask.tasks.chemequation.storage;

import com.chemcool.school.answerstask.tasks.chemequation.domain.ChemEquationsTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemEquationsTaskEventJournal
        extends JpaRepository<ChemEquationsTaskEvent, String> {
}
