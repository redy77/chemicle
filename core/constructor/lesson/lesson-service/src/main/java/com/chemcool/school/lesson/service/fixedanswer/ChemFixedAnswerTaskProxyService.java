package com.chemcool.school.lesson.service.fixedanswer;

import com.chemcool.school.lesson.domain.fixedanswer.ChemFixedAnswerTask;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ChemFixedAnswerTaskProxyService {

    private final ChemFixedAnswerTaskService taskService;

    public Optional<ChemFixedAnswerTask> getById(String id) {
        return taskService.getById(id);
    }

    public List<ChemFixedAnswerTask> getAll() {
        return taskService.getAll();
    }

    public List<ChemFixedAnswerTask> getAllByChapterId(Integer chapterId) {
        return taskService.getAllByChapterId(chapterId);
    }

    public List<ChemFixedAnswerTask> getAllByReferenceId(Integer referenceId) {
        return taskService.getAllByReferenceId(referenceId);
    }

    public List<ChemFixedAnswerTask> getAllByReferenceIdAndChapterId(Integer referenceId, Integer chapterId){
        return taskService.getAllByReferenceIdAndChapterId(referenceId, chapterId);
    }
}

