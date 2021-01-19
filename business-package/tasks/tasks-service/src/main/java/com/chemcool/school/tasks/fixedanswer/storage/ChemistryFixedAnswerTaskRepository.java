package com.chemcool.school.tasks.fixedanswer.storage;

import com.chemcool.school.tasks.fixedanswer.domain.ChemistryFixedAnswerTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemistryFixedAnswerTaskRepository extends JpaRepository<ChemistryFixedAnswerTask, String>, JpaSpecificationExecutor<ChemistryFixedAnswerTask> {
    List<ChemistryFixedAnswerTask> findAllByChapterId(String chapterId);
}
