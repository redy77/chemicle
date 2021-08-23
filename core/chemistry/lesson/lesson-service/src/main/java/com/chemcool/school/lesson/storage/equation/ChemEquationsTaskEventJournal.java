package com.chemcool.school.lesson.storage.equation;

import com.chemcool.school.lesson.domain.equation.ChemEquationsTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemEquationsTaskEventJournal
        extends JpaRepository<ChemEquationsTaskEvent, String> {
}
