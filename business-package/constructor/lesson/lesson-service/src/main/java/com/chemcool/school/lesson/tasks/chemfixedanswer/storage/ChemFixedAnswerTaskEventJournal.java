package com.chemcool.school.lesson.tasks.chemfixedanswer.storage;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChemFixedAnswerTaskEventJournal extends JpaRepository<ChemFixedAnswerTaskEvent, String>, JpaSpecificationExecutor<ChemFixedAnswerTask> {
}
