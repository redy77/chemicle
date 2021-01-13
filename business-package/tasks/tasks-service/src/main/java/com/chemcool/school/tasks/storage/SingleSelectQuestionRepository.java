package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.SingleSelectQuestion;
import com.chemcool.school.tasks.domain.TypeOfTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingleSelectQuestionRepository extends JpaRepository<SingleSelectQuestion, String> {
    List<SingleSelectQuestion> findByTypeOfTask(TypeOfTask typeOfTask);
    List<SingleSelectQuestion> findAllByChapterId(String id);
}
