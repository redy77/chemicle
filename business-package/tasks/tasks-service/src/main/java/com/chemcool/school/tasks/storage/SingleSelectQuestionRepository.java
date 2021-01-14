package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.SingleSelectQuestionTask;
import com.chemcool.school.tasks.domain.TypeOfTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingleSelectQuestionRepository extends JpaRepository<SingleSelectQuestionTask, String> {
    List<SingleSelectQuestionTask> findByTypeOfTask(TypeOfTask typeOfTask);
    List<SingleSelectQuestionTask> findAllByChapterId(String id);
}
