package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.MatchingOfTwoSidesTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingTaskOfTwoSidesRepository extends JpaRepository<MatchingOfTwoSidesTask, String> {
    List<MatchingOfTwoSidesTask> findByChapterId(String id);
}
