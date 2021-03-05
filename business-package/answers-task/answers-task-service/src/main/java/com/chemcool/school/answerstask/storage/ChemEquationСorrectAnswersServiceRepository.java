package com.chemcool.school.answerstask.storage;

import com.chemcool.school.answerstask.web.api.domain.ChemEquationСorrectAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemEquationСorrectAnswersServiceRepository extends JpaRepository<ChemEquationСorrectAnswers, String> {
}
