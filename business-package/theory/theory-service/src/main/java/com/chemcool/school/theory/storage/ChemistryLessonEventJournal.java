package com.chemcool.school.theory.storage;

import com.chemcool.school.theory.domain.ChemistryLessonEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemistryLessonEventJournal extends JpaRepository<ChemistryLessonEvent, String> {
}
