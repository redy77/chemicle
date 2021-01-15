package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.ChemistryFixedAnswerTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChemistryFixedAnswerTaskRepository extends JpaRepository<ChemistryFixedAnswerTask, UUID>, JpaSpecificationExecutor<ChemistryFixedAnswerTask> {
    List<ChemistryFixedAnswerTask> findAllByChapterId(String id);
}
