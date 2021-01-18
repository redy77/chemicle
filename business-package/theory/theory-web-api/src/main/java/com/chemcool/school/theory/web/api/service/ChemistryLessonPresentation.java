package com.chemcool.school.theory.web.api.service;

import com.chemcool.school.theory.domain.ChemistryLessonExample;
import com.chemcool.school.theory.service.ChemistryLessonPageService;
import com.chemcool.school.theory.web.api.dto.LessonExample;
import com.chemcool.school.theory.web.api.exception.ChemistryLessonEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryLessonPresentation {

    private final ChemistryLessonPageService service;

    public String createChemistryLessonExample(LessonExample example) {
        if (
                example.getLessonExampleName().isEmpty()
        ) {
            throw new ChemistryLessonEmptyException("Необходимые поля пустые, проверьте пожалуйста бланк заполнения темы.");
        } else {
            return service.manageLesson(
                    new ChemistryLessonExample(
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
                new ChemistryLessonExample(
                        example.getLessonExampleName(),
                        example.getLessonExampleDescription(),
                        example.getLessonExampleChapter(),
                        example.getLessonExampleReferences()
                )
        );
    }

    public String updateChemistryLessonExample(LessonExample example) {
        return service.manageLesson(
                new ChemistryLessonExample(
                        example.getLessonExampleName(),
                        example.getLessonExampleDescription(),
                        example.getLessonExampleChapter(),
                        example.getLessonExampleReferences()
                )
        );
    }
}
