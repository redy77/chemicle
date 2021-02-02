package com.chemcool.school.theory.web.api.service;

import com.chemcool.school.theory.domain.ChemistryTheory;
import com.chemcool.school.theory.domain.ChemistryTheoryExample;
import com.chemcool.school.theory.service.ChemistryTheoryPageService;
import com.chemcool.school.theory.web.api.dto.TheoryExample;
import com.chemcool.school.theory.web.api.exception.ChemistryTheoryEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryTheoryPresentation {

    private final ChemistryTheoryPageService service;

    public String createChemistryTheoryExample(TheoryExample example) {
        if (
                example.getTheoryExampleName().isEmpty()
        ) {
            throw new ChemistryTheoryEmptyException("Необходимые поля пустые, проверьте пожалуйста бланк заполнения темы.");
        } else {
            return service.manageTheory(
                    new ChemistryTheoryExample(
                            example.getTheoryExampleName(),
                            example.getTheoryExampleDescription(),
                            example.getTheoryExampleChapter(),
                            example.getTheoryExampleReferences()
                    )
            );
        }
    }

    public void deleteChemistryTheoryExample(TheoryExample example) {
        service.deleteTheory(
                new ChemistryTheoryExample(
                        example.getTheoryExampleName(),
                        example.getTheoryExampleDescription(),
                        example.getTheoryExampleChapter(),
                        example.getTheoryExampleReferences()
                )
        );
    }

    public String updateChemistryTheoryExample(String TheoryId, TheoryExample example) {
        ChemistryTheoryExample chemistryTheoryExample = ChemistryTheoryExample.fromTheoryExample(
                example.getTheoryExampleName(),
                example.getTheoryExampleDescription(),
                example.getTheoryExampleChapter(),
                example.getTheoryExampleReferences()
        );
        return service.updateTheory(TheoryId, chemistryTheoryExample);
    }

    public ChemistryTheory getTheoryById(String theoryId) {
        return service.findTheoryById(theoryId);
    }
}
