package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.FixedAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FixedAnswerRepository extends JpaRepository<FixedAnswer, String>, JpaSpecificationExecutor<FixedAnswer> {
    List<FixedAnswer> findAllByChapterId(String id);
}
