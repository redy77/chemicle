package com.chemcool.school.theory.web.api.service;

import com.chemcool.school.theory.domain.ChemistryTheory;
import com.chemcool.school.theory.domain.ChemistryTheoryExample;
import com.chemcool.school.theory.service.ChemistryTheoryPageService;
import com.chemcool.school.theory.web.api.dto.LessonExample;
import com.chemcool.school.theory.web.api.exception.ChemistryLessonEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryLessonPresentation {

    private final ChemistryTheoryPageService service;

    public String createChemistryLessonExample(LessonExample example) {
        if (
                example.getLessonExampleName().isEmpty()
        ) {
            throw new ChemistryLessonEmptyException("Необходимые поля пустые, проверьте пожалуйста бланк заполнения темы.");
        } else {
            return service.manageLesson(
                    new ChemistryTheoryExample(
                            example.getLessonExampleName(),
                            example.getLessonExampleDescription(),
                            example.getLessonExampleChapter(),
                            example.getLessonExampleReferences()
                    )
            );
        }
    }

    public void deleteChemistryLessonExample(LessonExample example) {
        service.deleteLesson(
                new ChemistryTheoryExample(
                        example.getLessonExampleName(),
                        example.getLessonExampleDescription(),
                        example.getLessonExampleChapter(),
                        example.getLessonExampleReferences()
                )
        );
    }

    public String updateChemistryLessonExample(String lessonId, LessonExample example) {
        ChemistryTheoryExample chemistryTheoryExample = ChemistryTheoryExample.fromLessonExample(
                example.getLessonExampleName(),
                example.getLessonExampleDescription(),
                example.getLessonExampleChapter(),
                example.getLessonExampleReferences()
        );
        return service.updateLesson(lessonId, chemistryTheoryExample);
    }

    public ChemistryTheory getLessonById(String lessonId){
        return service.findLessonById(lessonId);
    }


}
