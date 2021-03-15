package com.chemcool.school.lesson.tasks.chemmatches.storage;

import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTask;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemistryMatchingTaskEventJournal extends JpaRepository<ChemistryMatchingTaskEvent, String>, JpaSpecificationExecutor<ChemistryMatchingTask> {
}
