package com.chemcool.school.answers.tasks.chemsingleselect.storage;


import com.chemcool.school.answers.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemSingleSelectTaskEventJournal extends JpaRepository<ChemSingleSelectTaskEvent, String> {
}
