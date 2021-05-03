package com.chemcool.school.tasks.chemmatches.infrastructure.storage;

import com.chemcool.school.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemistryMatchingTaskEventJournal extends JpaRepository<ChemistryMatchingTaskEvent, String> {
}
