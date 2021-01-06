package com.chemcool.school.service;


import com.chemcool.school.domain.ChemistryLessonPage;
import com.chemcool.school.domain.ChemistryLessonExample;
import com.chemcool.school.storage.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryLessonPageService {

    private final LessonRepository repository;

    public String manageLesson(ChemistryLessonExample example) {
        ChemistryLessonPage lessonPage = ChemistryLessonPage.createLesson(example);
        repository.save(lessonPage);
        return lessonPage.getLessonId();
    }

}
