package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.theory.domain.ChemTheory;
import com.chemcool.school.lesson.theory.service.ChemTheoryProxyService;
import com.chemcool.school.lesson.web.api.dto.ChemTheoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemTheoryServiceLayer {

    private final ChemTheoryProxyService service;

    public List<ChemTheoryDto> getAllTheoryDto () {
        List<ChemTheoryDto> list = new ArrayList<>();
        for(ChemTheory task : service.getAll()){
            list.add(new ChemTheoryDto(task));
        }
        return list;
    }
    public ChemTheoryDto findTheoryByIdDto(String theoryId){
        ChemTheory theory = service.getById(theoryId);
        return  new ChemTheoryDto(theory);
    }

    public List<ChemTheoryDto> getAllTheoryByReferenceIdDto (int referenceId) {
        List<ChemTheoryDto> list = new ArrayList<>();
        for(ChemTheory task : service.getAllByReferenceId(referenceId)){
            list.add(new ChemTheoryDto(task));
        }
        return list;
    }

    public List<ChemTheoryDto> getAllTheoryByChapterIdDto (int chapterId) {
        List<ChemTheoryDto> list = new ArrayList<>();
        for(ChemTheory task : service.getAllByChapterId(chapterId)){
            list.add(new ChemTheoryDto(task));
        }
        return list;
    }

    public List<ChemTheoryDto> getAllTheoryByReferenceIdIndChapterIdDto (int referenceId, int chapterId) {
        List<ChemTheoryDto> list = new ArrayList<>();
        for(ChemTheory task : service.getAllByReferenceIdAndChapterId(referenceId, chapterId)){
            list.add(new ChemTheoryDto(task));
        }
        return list;
    }
}
