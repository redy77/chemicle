package com.chemcool.school.chemmatches.service;

import com.chemcool.school.chemmatches.domain.ChemistryMatchingTask;
import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskEvent;
import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskExample;
import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskFactory;
import com.chemcool.school.chemmatches.storage.ChemistryMatchingTaskEventJournal;
import com.chemcool.school.chemmatches.storage.ChemistryMatchingTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistryMatchingTaskService {

    private final ChemistryMatchingTaskRepository repository;
    private final ChemistryMatchingTaskEventService eventService;


    public String add(ChemistryMatchingTaskExample taskExample) {
        ChemistryMatchingTask task = ChemistryMatchingTaskFactory.createChemistryMatchingTask(taskExample);
        eventService.save(task);
        repository.save(task);
        log.info("Добавлена с задача с id: " + task.getTaskId());
        return task.getTaskId();
    }

    public Optional<ChemistryMatchingTask> getById(String id) {
        return repository.findById(id);
    }

    public List<ChemistryMatchingTask> getAll() {
        return repository.findAll();
    }

    public List<ChemistryMatchingTask> getAllByChapterId(String chapterId) {
        log.info("Поиск всех задааний по chapterId = " + chapterId);
        return repository.findByChapterId(chapterId);
    }

    public void update(ChemistryMatchingTask task) {
        eventService.update(task);
        repository.save(task);
        log.info("Обновлена с задача с id: " + task.getTaskId());
    }

    public void deleteById(String id) {
        repository.deleteById(id);
        log.info("Удалена с задача с id: " + id);
    }

}