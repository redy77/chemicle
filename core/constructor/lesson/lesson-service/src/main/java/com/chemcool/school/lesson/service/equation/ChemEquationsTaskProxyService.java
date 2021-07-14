package com.chemcool.school.lesson.service.equation;

import com.chemcool.school.lesson.domain.equation.ChemEquationsTask;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    public List<ChemEquationsTask> getAllByChapterId(Integer chapterId) {
        return taskService.getAllByChapterId(chapterId);
    }

    public List<ChemEquationsTask> getAllByReferenceId (Integer referenceId) {
        return taskService.getAllByReferenceId(referenceId);
    }

    public List<ChemEquationsTask> getAllByReferenceIdAndChapterId(Integer referenceId, Integer chapterId) {
        return taskService.getAllByReferenceIdAndChapterId(referenceId,chapterId);
    }

    public boolean[] checkAnswer(String taskId, String userAnswer) {
        return taskService.checkAnswer(taskId, userAnswer);
    }

}