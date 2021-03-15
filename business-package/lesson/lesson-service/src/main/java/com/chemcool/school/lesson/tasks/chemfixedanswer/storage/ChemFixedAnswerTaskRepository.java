package com.chemcool.school.lesson.tasks.chemfixedanswer.storage;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemFixedAnswerTaskRepository extends JpaRepository<ChemFixedAnswerTask, String>, JpaSpecificationExecutor<ChemFixedAnswerTask> {
    List<ChemFixedAnswerTask> getAllByChapterId(int chapterId);
    List<ChemFixedAnswerTask> getChemFixedAnswerTaskByChapterId(int chapterId);
    List<ChemFixedAnswerTask> getChemFixedAnswerTaskByReferenceId(int referenceId);
}
