package com.chemcool.school.domain.storage;

import com.chemcool.school.domain.tasks.domain.SingleSelectQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleSelectQuestionRepository extends JpaRepository<SingleSelectQuestion, String> {
}
