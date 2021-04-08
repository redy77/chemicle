package com.chemcool.school.lesson.tasks.chemequations.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.chemcool.school.lesson.tasks.chemequations.domain.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ChemEquationsTaskProxyService {



    private final ChemEquationsTaskService taskService;

    public Optional<ChemEquationsTask> getById(String id) {
        return taskService.getById(id);
    }

    public List<ChemEquationsTask> getAll() {
        return taskService.getAll();
    }

    public List<ChemEquationsTask> getAllByChapterId(int chapterId) {
        return taskService.getAllByChapterId(chapterId);
    }

    public List<ChemEquationsTask> getAllByReferenceId (int referenceId) {return taskService.getAllByReferenceId(referenceId);}

    public List<ChemEquationsTask> getAllByChapterIdAndReferenceId(int chapterId,int referenceId) {
        return taskService.getAllByChapterIdAndReferenceId(chapterId,referenceId);
    }

    public boolean[] checkAnswer(String taskId, String userAnswer) {
        return taskService.checkAnswer(taskId, userAnswer);
    }

}