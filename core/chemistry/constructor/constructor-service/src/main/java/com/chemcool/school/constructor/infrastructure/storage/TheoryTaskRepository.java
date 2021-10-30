package com.chemcool.school.constructor.infrastructure.storage;

import com.chemcool.school.constructor.domain.TheoryTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheoryTaskRepository extends JpaRepository<TheoryTask, String> {
}
