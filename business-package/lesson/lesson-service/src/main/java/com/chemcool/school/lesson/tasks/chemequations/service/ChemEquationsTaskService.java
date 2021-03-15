package com.chemcool.school.lesson.tasks.chemequations.service;

import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.lesson.tasks.chemequations.storage.ChemEquationsTaskRepository;
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
   // private final ChemEquationsTaskAnswerCheckService checkService;

    public void save(ChemEquationsTask task) {
        repository.save(task);
        log.info("Добавлена задача с UUID = " + task.getTaskId() );
    }

    public Optional<ChemEquationsTask> getById(String id) {
        return repository.findById(id);
    }

    public List<ChemEquationsTask> getAll() {
        return repository.findAll();
    }

    public List<ChemEquationsTask> getAllByChapterId(int chapterId) {
        return repository.getAllByChapterId(chapterId);
    }
    public void update(ChemEquationsTask task) {
        log.info("Обновлена задача с UUID = " + task.getTaskId() );
        repository.save(task);
    }

    public List<ChemEquationsTask> findTaskByChapter(int chapterId) {
        log.info("Найдены задачи Equations с chapter = " + chapterId );
        return repository.findChemEquationsTaskByChapterId(chapterId);
    }

    public List<ChemEquationsTask> findTaskByReferences(int referencesId){
        log.info("Найдены задачи Equations с references = " + referencesId );
        return repository.findChemEquationsTaskByReferenceId(referencesId);
    }
    public void deleteById(String id) {
        log.info("Удалена задачу с UUID = " + id);
        repository.deleteById(id);
    }


}

