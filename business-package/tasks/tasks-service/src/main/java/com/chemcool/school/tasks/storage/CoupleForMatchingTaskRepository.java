package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.CoupleForMatchingTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupleForMatchingTaskRepository extends JpaRepository<CoupleForMatchingTask, String> {
}
