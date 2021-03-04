package com.chemcool.school.answerstask.tasks.chemequitation.storage;

import com.chemcool.school.answerstask.tasks.chemequitation.domain.ChemEquationsTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemEquationsTaskEventJournal
        extends JpaRepository<ChemEquationsTaskEvent, String> {
}
