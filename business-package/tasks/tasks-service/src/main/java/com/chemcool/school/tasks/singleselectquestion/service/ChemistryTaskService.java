package com.chemcool.school.tasks.singleselectquestion.service;

import java.util.List;
import java.util.Optional;

public interface ChemistryTaskService<T, E> {
    String add(E e);
    Optional<T> getById(String id);
    List<T> getAll();
    List<T> getAllByChapterId(String chapterId);
    void update(T t);
    void deleteById(String id);
}

