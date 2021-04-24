package com.chemcool.school.lesson.tasks.chemmatches.storage;

import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTask;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemMatchingTaskEventJournal extends JpaRepository<ChemMatchingTaskEvent, String>, JpaSpecificationExecutor<ChemMatchingTask> {
}
