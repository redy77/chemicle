package com.chemcool.school.answers.tasks.chemfixedanswer.storage;

import com.chemcool.school.answers.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemFixedAnswerTaskEventJournal extends JpaRepository<ChemFixedAnswerTaskEvent, String> {
}
