package com.chemcool.school.tasks.chemfixedanswer.storage;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemFixedAnswerTaskRepository extends JpaRepository<ChemFixedAnswerTask, String>, JpaSpecificationExecutor<ChemFixedAnswerTask> {
    List<ChemFixedAnswerTask> findAllByChapterId(int chapterId);
}
