package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.MatchingTaskOfTwoSides;
import com.chemcool.school.tasks.storage.MatchingTaskOfTwoSidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchingTaskOfTwoSidesService implements TaskService<MatchingTaskOfTwoSides> {

    private final MatchingTaskOfTwoSidesRepository matchingTaskOfTwoSidesRepository;

    @Autowired
    public MatchingTaskOfTwoSidesService(MatchingTaskOfTwoSidesRepository matchingTaskOfTwoSidesRepository) {
        this.matchingTaskOfTwoSidesRepository = matchingTaskOfTwoSidesRepository;
    }

    @Override
    public String add(MatchingTaskOfTwoSides matchingTaskOfTwoSides) {
        matchingTaskOfTwoSidesRepository.save(matchingTaskOfTwoSides);
        return "";
    }

    @Override
    public Optional<MatchingTaskOfTwoSides> getById(String id) {
        return matchingTaskOfTwoSidesRepository.findById(id);
    }

    @Override
    public List<MatchingTaskOfTwoSides> getAll() {
        return matchingTaskOfTwoSidesRepository.findAll();
    }

    @Override
    public List<MatchingTaskOfTwoSides> getAllByChapterId(String id) {
        return matchingTaskOfTwoSidesRepository.findByChapterId(id);
    }

    @Override
    public void update(MatchingTaskOfTwoSides matchingTaskOfTwoSides) {
        matchingTaskOfTwoSidesRepository.save(matchingTaskOfTwoSides);
    }

    @Override
    public void deleteById(String id) {
        matchingTaskOfTwoSidesRepository.deleteById(id);
    }
}
