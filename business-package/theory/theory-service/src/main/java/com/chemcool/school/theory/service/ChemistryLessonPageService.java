package com.chemcool.school.theory.service;


import com.chemcool.school.theory.domain.ChemistryLesson;
import com.chemcool.school.theory.domain.ChemistryLessonExample;
import com.chemcool.school.theory.domain.ChemistryLessonFactory;
import com.chemcool.school.theory.storage.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChemistryLessonPageService {

    private final LessonRepository repository;

    public String manageLesson(ChemistryLessonExample example) {
        ChemistryLesson lessonPage = ChemistryLessonFactory.createLesson(example);
        repository.save(lessonPage);
        return lessonPage.getLessonId();
    }

    public void deleteLesson(ChemistryLessonExample example) {
        ChemistryLesson lessonPage = ChemistryLessonFactory.createLesson(example);
        repository.delete(lessonPage);
    }

    public String updateLesson(String lessonId, ChemistryLessonExample chemistryLessonExample) {

        //  TODO проверить на то, что lessonId не пустой.
        if (lessonId.isEmpty() || lessonId == null) {
            throw new RuntimeException("lessonId параметр пустой, проверьте конфигурацию.");
        }

        repository.updateLesson(
                lessonId,
                chemistryLessonExample.getLessonExampleName(),
                chemistryLessonExample.getLessonExampleChapter(),
                chemistryLessonExample.getLessonExampleDescription(),
                chemistryLessonExample.getLessonExampleReferences()
        );

        return lessonId;
    }

    public  ChemistryLesson findLessonById(String lessonId){
        //  TODO проверить на то, что lessonId не пустой.
        if (  lessonId == null || lessonId.isEmpty()) {
            throw new RuntimeException("lessonId параметр пустой, проверьте конфигурацию.");
        }
        return repository.findByLessonId(lessonId);

    }

}
