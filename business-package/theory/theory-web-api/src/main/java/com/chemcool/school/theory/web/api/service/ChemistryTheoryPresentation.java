package com.chemcool.school.theory.web.api.service;

import com.chemcool.school.theory.domain.ChemistryTheory;
import com.chemcool.school.theory.domain.ChemistryTheoryExample;
import com.chemcool.school.theory.web.api.dto.TheoryDto;
import com.chemcool.school.theory.web.api.exception.ChemistryTheoryEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryTheoryPresentation {


  //  private final ChemistryTheoryPageService service;
    private final ChemistryTheoryServiceLayer serviceLayer;

    public String createChemistryTheoryDto(TheoryDto dto) {
        if (
                dto.getTheoryName().isEmpty()
        ) {
            throw new ChemistryTheoryEmptyException("Необходимые поля пустые, проверьте пожалуйста бланк заполнения темы.");
        } else {
            return serviceLayer.add(dto);
//            return serviceLayer.save(
//                    new ChemistryTheoryExample(
//                            dto.getTheoryName(),
//                            dto.getTheoryDescription(),
//                            dto.getTheoryChapter(),
//                            dto.getTheoryReferences()
//                    )
//            );
        }
    }

    public void deleteChemistryTheoryDto(TheoryDto dto) {
        serviceLayer.delete(dto);
//        service.delete(
//                new ChemistryTheoryExample(
//                        example.getTheoryName(),
//                        example.getTheoryDescription(),
//                        example.getTheoryChapter(),
//                        example.getTheoryReferences()
//                )
//        );
    }

    public void updateChemistryTheoryDto(TheoryDto dto) {
//        ChemistryTheoryExample chemistryTheoryExample = ChemistryTheoryExample.fromTheoryExample(
//                example.getTheoryName(),
//                example.getTheoryDescription(),
//                example.getTheoryChapter(),
//                example.getTheoryReferences()
//        );
        serviceLayer.update(dto);
      //  return service.update(chemistryTheoryExample);
    }

    public ChemistryTheory getTheoryById(String theoryId) {
        return serviceLayer.findTheoryById(theoryId);
    }
}
