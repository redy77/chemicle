package com.chemcool.school.lesson.service.command;

import com.chemcool.school.lesson.domain.ChemistryLesson;
import com.chemcool.school.lesson.storage.LessonRepository;
import com.chemcool.school.lesson.theory.domain.ChemistryTheory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistryLessonPageService {

    private  final LessonRepository repository;

    public String save(ChemistryLesson lesson) {
        repository.save(lesson);
        log.info("Сохранил теорию c UUID" + lesson.getLessonId());
        return lesson.getLessonId();
    }

    public ChemistryLesson findTaskAndTheoryByChapter(int chapter){
        if (chapter == 0 ){
            throw new RuntimeException("chapter параметр пустой");
        }
        return repository.findLessonByChapter(chapter);
    }


    public ChemistryLesson findTaskAndTheoryByReferences(int references){
        if (references == 0 ){
            throw new RuntimeException("references параметр пустой");
        }
        return repository.findLessonByReferences(references);
    }







}
