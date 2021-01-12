package com.chemcool.school.domain.service;

import com.chemcool.school.domain.tasks.domain.SingleSelectQuestion;

import java.util.List;

public interface SingleSelectQuestionsService {
    List<SingleSelectQuestion> getAllTasks();
    SingleSelectQuestion getTaskById(String uuid);
    void deleteTaskById(String uuid);
    void add(SingleSelectQuestion singleSelectQuestion);

}
