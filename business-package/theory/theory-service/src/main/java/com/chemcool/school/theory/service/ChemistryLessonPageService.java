package com.chemcool.school.theory.service;


import com.chemcool.school.theory.domain.ChemistryLesson;
import com.chemcool.school.theory.domain.ChemistryLessonExample;
import com.chemcool.school.theory.domain.ChemistryLessonFactory;
import com.chemcool.school.theory.storage.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryLessonPageService {

    private final LessonRepository repository;

    public String manageLesson(ChemistryLessonExample example) {
        ChemistryLesson lessonPage = ChemistryLessonFactory.createLesson(example);
        repository.save(lessonPage);
        return lessonPage.getLessonId();
    }

}
