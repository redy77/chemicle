package com.chemcool.school.lesson.tasks.chemfixedanswer.storage;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemFixedAnswerTaskRepository extends JpaRepository<ChemFixedAnswerTask, String>, JpaSpecificationExecutor<ChemFixedAnswerTask> {
    List<ChemFixedAnswerTask> getAllByChapterId(int chapterId);
    List<ChemFixedAnswerTask> getAllByReferenceId(int referenceId);
    List<ChemFixedAnswerTask> getAllByReferenceIdAndChapterId(int referenceId, int chapterId);
}
