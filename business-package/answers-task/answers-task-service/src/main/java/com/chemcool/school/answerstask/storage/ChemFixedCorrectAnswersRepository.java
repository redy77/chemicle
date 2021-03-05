package com.chemcool.school.answerstask.storage;

import com.chemcool.school.answerstask.web.api.domain.ChemFixedCorrectAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemFixedCorrectAnswersRepository extends JpaRepository<ChemFixedCorrectAnswers, String> {
}
