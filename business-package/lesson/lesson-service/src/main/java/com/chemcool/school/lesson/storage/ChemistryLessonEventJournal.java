package com.chemcool.school.lesson.storage;

import com.chemcool.school.lesson.domain.ChemistryLessonEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemistryLessonEventJournal extends JpaRepository<ChemistryLessonEvent, String> {
}
