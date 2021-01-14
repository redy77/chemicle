package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.SingleSelectQuestionTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingleSelectQuestionTaskRepository extends JpaRepository<SingleSelectQuestionTask, String> {
    List<SingleSelectQuestionTask> getAllByChapterId(String id);
}
