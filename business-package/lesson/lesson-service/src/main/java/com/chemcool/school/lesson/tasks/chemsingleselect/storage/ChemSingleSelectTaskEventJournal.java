package com.chemcool.school.lesson.tasks.chemsingleselect.storage;


import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemSingleSelectTaskEventJournal extends JpaRepository<ChemSingleSelectTaskEvent, String> {
}
