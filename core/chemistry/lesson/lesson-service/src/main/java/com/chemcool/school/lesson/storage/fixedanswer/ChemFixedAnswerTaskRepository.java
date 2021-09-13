package com.chemcool.school.lesson.storage.fixedanswer;

import com.chemcool.school.lesson.domain.fixedanswer.ChemFixedAnswerTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemFixedAnswerTaskRepository extends JpaRepository<ChemFixedAnswerTask, String>, JpaSpecificationExecutor<ChemFixedAnswerTask> {
    List<ChemFixedAnswerTask> getAllByChapterId(Integer chapterId);
    List<ChemFixedAnswerTask> getAllByReferenceId(Integer referenceId);
    List<ChemFixedAnswerTask> getAllByReferenceIdAndChapterId(Integer referenceId, Integer chapterId);
}
