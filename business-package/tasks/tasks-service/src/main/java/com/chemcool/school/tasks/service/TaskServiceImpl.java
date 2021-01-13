package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.ChemistryEquationTask;
import com.chemcool.school.tasks.storage.ChemistryEquationTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService<ChemistryEquationTask> {

    private final ChemistryEquationTaskRepository repository;

    @Override
    public void add(ChemistryEquationTask chemistryEquationTask) {
        repository.save(chemistryEquationTask);
    }

    @Override
    public Optional<ChemistryEquationTask> getById(String id) {
        return repository.findById(UUID.fromString(id));
    }

    @Override
    public List<ChemistryEquationTask> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ChemistryEquationTask> getAllByChapterId(String id) {
        return repository.getAllByChapterId(id);
    }

    @Override
    public void update(ChemistryEquationTask chemistryEquationTask) {
        repository.save(chemistryEquationTask);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(UUID.fromString(id));
    }
}
