package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.SingleSelectQuestion;

import java.util.List;
import java.util.Optional;

public class SingleSelectQuestionImpl implements TaskService<SingleSelectQuestion>{
    @Override
    public void add(SingleSelectQuestion singleSelectQuestion) {

    }

    @Override
    public Optional<SingleSelectQuestion> getById(String id) {
        return Optional.empty();
    }

    @Override
    public List<SingleSelectQuestion> getAll() {
        return null;
    }

    @Override
    public List<SingleSelectQuestion> getAllByChapterId(String id) {
        return null;
    }

    @Override
    public void update(SingleSelectQuestion singleSelectQuestion) {

    }

    @Override
    public void deleteById(String id) {

    }
}
