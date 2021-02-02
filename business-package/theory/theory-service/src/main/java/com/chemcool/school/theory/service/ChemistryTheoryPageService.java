package com.chemcool.school.theory.service;


import com.chemcool.school.theory.domain.ChemistryTheory;
import com.chemcool.school.theory.domain.ChemistryTheoryEvent;
import com.chemcool.school.theory.domain.ChemistryTheoryExample;
import com.chemcool.school.theory.domain.ChemistryTheoryFactory;
import com.chemcool.school.theory.storage.ChemistryTheoryEventJournal;
import com.chemcool.school.theory.storage.TheoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ChemistryTheoryPageService {

    private final TheoryRepository repository;
    private final ChemistryTheoryEventJournal journal;
    private final ChemistryTheoryEventService pageService;


    public String manageLesson(ChemistryTheoryExample example) {
        ChemistryTheory lessonPage = ChemistryTheoryFactory.createLesson(example);
        pageService.save(lessonPage);
        repository.save(lessonPage);
        return lessonPage.getLessonId();
    }

    public void deleteLesson(ChemistryTheoryExample example) {
        ChemistryTheory lessonPage = ChemistryTheoryFactory.createLesson(example);
        repository.delete(lessonPage);
    }

    public String updateLesson(String lessonId, ChemistryTheoryExample chemistryTheoryExample) {

        //  TODO проверить на то, что lessonId не пустой.
        if (lessonId == null || lessonId.isEmpty()) {
            throw new RuntimeException("lessonId параметр пустой, проверьте конфигурацию.");
        }

        pageService.update(ChemistryTheory.createChemistryLesson(
                chemistryTheoryExample
        ));
        repository.updateLesson(
                lessonId,
                chemistryTheoryExample.getLessonExampleName(),
                chemistryTheoryExample.getLessonExampleChapter(),
                chemistryTheoryExample.getLessonExampleDescription(),
                chemistryTheoryExample.getLessonExampleReferences()
        );

        return lessonId;
    }

    public ChemistryTheory findLessonById(String lessonId) {
        //  TODO проверить на то, что lessonId не пустой.
        if (lessonId == null || lessonId.isEmpty()) {
            throw new RuntimeException("lessonId параметр пустой, проверьте конфигурацию.");
        }
        return repository.findByLessonId(lessonId);

    }


    public void handleEvent(ChemistryTheoryEvent event) {
        journal.save(event);
    }

}
