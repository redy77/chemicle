package com.chemcool.school.domain.tasks.storage;

import com.chemcool.school.domain.tasks.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, String> {
}
