package com.chemcool.school.lesson.tasks.chemmatches.storage;

import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemMatchingTaskRepository extends JpaRepository<ChemMatchingTask, String>, JpaSpecificationExecutor<ChemMatchingTask> {
    List<ChemMatchingTask> getAllByChapterId(Integer chapterId);
    List<ChemMatchingTask>getAllByReferenceId(Integer referencesId);
}