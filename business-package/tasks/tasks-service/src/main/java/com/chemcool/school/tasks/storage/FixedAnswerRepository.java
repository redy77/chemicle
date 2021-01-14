package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.FixedAnswerTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixedAnswerRepository extends JpaRepository<FixedAnswerTask, String>, JpaSpecificationExecutor<FixedAnswerTask> {
    List<FixedAnswerTask> findAllByChapterId(String id);
}
