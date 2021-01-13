package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.MatchingTaskOfTwoSides;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingTaskOfTwoSidesRepository extends JpaRepository<MatchingTaskOfTwoSides, String> {
    List<MatchingTaskOfTwoSides> findByChapterId(String id);
}
