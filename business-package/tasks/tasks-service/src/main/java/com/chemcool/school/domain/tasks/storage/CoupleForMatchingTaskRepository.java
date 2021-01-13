package com.chemcool.school.domain.tasks.storage;

import com.chemcool.school.domain.tasks.domain.CoupleForMatchingTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupleForMatchingTaskRepository extends JpaRepository<CoupleForMatchingTask, String> {
}
