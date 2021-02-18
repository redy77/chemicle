package com.chemcool.school.tasks.chemequations.service;

import com.chemcool.school.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.tasks.chemequations.storage.ChemEquationsTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemEquationsTaskService {

    private final ChemEquationsTaskRepository repository;

    public String save(ChemEquationsTask task) {
        repository.save(task);
        log.info("Задача с ID: " + task.getTaskId() + " сохранена.");
        return task.getTaskId();
    }

    public Optional<ChemEquationsTask> getById(String id) {
        return repository.findById(id);
    }

    public List<ChemEquationsTask> getAll() {
        return repository.findAll();
    }

    public List<ChemEquationsTask> getAllByChapterId(int chapterId) {
        return repository.findAllByChapterId(chapterId);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
