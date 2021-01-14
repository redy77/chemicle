package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.CoupleForMatching;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupleForMatchingTaskRepository extends JpaRepository<CoupleForMatching, String> {
}
