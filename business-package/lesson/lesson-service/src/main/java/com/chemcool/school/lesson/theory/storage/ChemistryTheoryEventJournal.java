package com.chemcool.school.lesson.theory.storage;


import com.chemcool.school.lesson.theory.domain.ChemistryTheoryEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemistryTheoryEventJournal extends JpaRepository<ChemistryTheoryEvent, String> {
}
