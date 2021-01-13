package com.chemcool.school.domain.tasks.storage;

import com.chemcool.school.domain.tasks.domain.MatchingTaskOfTwoSides;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchingTaskOfTwoSidesRepository extends JpaRepository<MatchingTaskOfTwoSides, String> {
}
