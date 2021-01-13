package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.SingleSelectQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleSelectQuestionRepository extends JpaRepository<SingleSelectQuestion, String> {
}
