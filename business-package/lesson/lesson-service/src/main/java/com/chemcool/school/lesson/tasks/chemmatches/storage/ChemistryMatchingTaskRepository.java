package com.chemcool.school.lesson.tasks.chemmatches.storage;

import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemistryMatchingTaskRepository extends JpaRepository<ChemistryMatchingTask, String>, JpaSpecificationExecutor<ChemistryMatchingTask> {
    List<ChemistryMatchingTask> getAllByChapterId(Integer chapterId);
    List<ChemistryMatchingTask>getAllByReferenceId(Integer referencesId);
}