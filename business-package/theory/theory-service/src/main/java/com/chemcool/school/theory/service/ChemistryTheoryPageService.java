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


    public String manageTheory(ChemistryTheoryExample example) {
        ChemistryTheory theoryPage = ChemistryTheoryFactory.createTheory(example);
        pageService.save(theoryPage);
        repository.save(theoryPage);
        return theoryPage.getTheoryId();
    }

    public void deleteTheory(ChemistryTheoryExample example) {
        ChemistryTheory theoryPage = ChemistryTheoryFactory.createTheory(example);
        repository.delete(theoryPage);
    }

    public String updateTheory(String theoryId, ChemistryTheoryExample chemistryTheoryExample) {

        //  TODO проверить на то, что lessonId не пустой.
        if (theoryId == null || theoryId.isEmpty()) {
            throw new RuntimeException("theoryId параметр пустой, проверьте конфигурацию.");
        }

        pageService.update(ChemistryTheory.createChemistryTheory(
                chemistryTheoryExample
        ));
        repository.updateTheory(
                theoryId,
                chemistryTheoryExample.getTheoryExampleName(),
                chemistryTheoryExample.getTheoryExampleChapter(),
                chemistryTheoryExample.getTheoryExampleDescription(),
                chemistryTheoryExample.getTheoryExampleReferences()
        );

        return theoryId;
    }

    public ChemistryTheory findTheoryById(String theoryId) {
        //  TODO проверить на то, что lessonId не пустой.
        if (theoryId == null || theoryId.isEmpty()) {
            throw new RuntimeException("theoryId параметр пустой, проверьте конфигурацию.");
        }
        return repository.findByTheoryId(theoryId);

    }


    public void handleEvent(ChemistryTheoryEvent event) {
        journal.save(event);
    }

}
