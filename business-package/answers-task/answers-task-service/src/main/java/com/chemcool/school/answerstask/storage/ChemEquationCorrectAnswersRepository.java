package com.chemcool.school.answerstask.storage;

import com.chemcool.school.answerstask.domain.ChemEquationCorrectAswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemEquationCorrectAnswersRepository extends JpaRepository<ChemEquationCorrectAswers, String> {
}
