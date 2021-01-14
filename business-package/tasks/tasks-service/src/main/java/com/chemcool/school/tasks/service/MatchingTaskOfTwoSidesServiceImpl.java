package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.MatchingOfTwoSidesTask;
import com.chemcool.school.tasks.storage.MatchingTaskOfTwoSidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MatchingTaskOfTwoSidesServiceImpl implements TaskService<MatchingOfTwoSidesTask> {

    private final MatchingTaskOfTwoSidesRepository matchingTaskOfTwoSidesRepository;

    @Autowired
    public MatchingTaskOfTwoSidesServiceImpl(MatchingTaskOfTwoSidesRepository matchingTaskOfTwoSidesRepository) {
        this.matchingTaskOfTwoSidesRepository = matchingTaskOfTwoSidesRepository;
    }

    @Override
    public String add(MatchingOfTwoSidesTask matchingOfTwoSidesTask) {
        matchingOfTwoSidesTask.setId(UUID.randomUUID().toString());
        matchingTaskOfTwoSidesRepository.save(matchingOfTwoSidesTask);
        return matchingOfTwoSidesTask.getId();
    }

    @Override
    public Optional<MatchingOfTwoSidesTask> getById(String id) {
        return matchingTaskOfTwoSidesRepository.findById(id);
    }

    @Override
    public List<MatchingOfTwoSidesTask> getAll() {
        return matchingTaskOfTwoSidesRepository.findAll();
    }

    @Override
    public List<MatchingOfTwoSidesTask> getAllByChapterId(String id) {
        return matchingTaskOfTwoSidesRepository.findByChapterId(id);
    }

    @Override
    public void update(MatchingOfTwoSidesTask matchingOfTwoSidesTask) {
        matchingTaskOfTwoSidesRepository.save(matchingOfTwoSidesTask);
    }

    @Override
    public void deleteById(String id) {
        matchingTaskOfTwoSidesRepository.deleteById(id);
    }
}
