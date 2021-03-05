package com.chemcool.school.answerstask.storage;

import com.chemcool.school.answerstask.web.api.domain.ChemSingleSelectCorrectAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemSingleSelectCorrectAnswerRepository extends JpaRepository<ChemSingleSelectCorrectAnswers, String> {
}
