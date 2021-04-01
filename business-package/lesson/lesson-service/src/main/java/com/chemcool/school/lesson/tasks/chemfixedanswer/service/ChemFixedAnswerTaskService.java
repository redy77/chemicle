package com.chemcool.school.lesson.tasks.chemfixedanswer.service;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.storage.ChemFixedAnswerTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskService {

    private final ChemFixedAnswerTaskRepository repository;

    public String save(ChemFixedAnswerTask task) {
        repository.save(task);
        log.info("Добавлена задача с UUID = " + task.getTaskId() );
        return task.getTaskId();
    }

    public Optional<ChemFixedAnswerTask> getById(String id) {
        return repository.findById(id);
    }

    public List<ChemFixedAnswerTask> getAll() {
        return repository.findAll();
    }

    public List<ChemFixedAnswerTask> getAllByChapterId(int chapterId) {
        return repository.getAllByChapterId(chapterId);
    }

    public void update(ChemFixedAnswerTask task) {
        log.info("Обновлена задача с UUID = " + task.getTaskId() );
        repository.save(task);
    }

    public void deleteById(String id) {
        log.info("Удалена задачу с UUID = " + id);
        repository.deleteById(id);
    }

    public List<ChemFixedAnswerTask> getAllByReferenceId(int referenceId){
        return repository.getAllByReferenceId(referenceId);
    }
}
