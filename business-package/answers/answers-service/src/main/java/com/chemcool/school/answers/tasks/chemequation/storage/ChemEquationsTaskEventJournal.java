package com.chemcool.school.answers.tasks.chemequation.storage;

import com.chemcool.school.answers.tasks.chemequation.domain.ChemEquationsTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemEquationsTaskEventJournal
        extends JpaRepository<ChemEquationsTaskEvent, String> {
}
