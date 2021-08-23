package com.chemcool.school.lesson.storage.theory;


import com.chemcool.school.lesson.domain.theory.ChemTheoryEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemTheoryEventJournal extends JpaRepository<ChemTheoryEvent, String> {
}
