package com.chemcool.school.lesson.storage;

import com.chemcool.school.lesson.domain.ChemistryLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LessonRepository extends JpaRepository<ChemistryLesson, UUID>, JpaSpecificationExecutor<ChemistryLesson> {

    ChemistryLesson findLessonByChapter(int chapter);

    ChemistryLesson findLessonByReferences(int references);



}
