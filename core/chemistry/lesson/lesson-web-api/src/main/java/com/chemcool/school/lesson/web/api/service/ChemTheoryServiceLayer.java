package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.domain.theory.ChemTheory;
import com.chemcool.school.lesson.service.theory.ChemTheoryProxyService;
import com.chemcool.school.lesson.web.api.dto.ChemTheoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public ChemTheoryDto getTheoryByIdDto(String theoryId){
        return service.getById(theoryId).map(ChemTheoryDto::new).orElse(null);

    }

    public List<ChemTheoryDto> getAllTheoryByReferenceIdDto (Integer referenceId) {
        List<ChemTheoryDto> list = new ArrayList<>();
        for(ChemTheory task : service.getAllByReferenceId(referenceId)){
            list.add(new ChemTheoryDto(task));
        }
        return list;
    }

    public List<ChemTheoryDto> getAllTheoryByChapterIdDto (Integer chapterId) {
        List<ChemTheoryDto> list = new ArrayList<>();
        for(ChemTheory task : service.getAllByChapterId(chapterId)){
            list.add(new ChemTheoryDto(task));
        }
        return list;
    }

    public List<ChemTheoryDto> getAllTheoryByReferenceIdIndChapterIdDto (Integer referenceId, Integer chapterId) {
        List<ChemTheoryDto> list = new ArrayList<>();
        for(ChemTheory task : service.getAllByReferenceIdAndChapterId(referenceId, chapterId)){
            list.add(new ChemTheoryDto(task));
        }
        return list;
    }

    public ChemTheoryDto getRandomChemTheoryDto() {
        List<ChemTheoryDto> list = new ArrayList<>();
        for (ChemTheory task : service.getAll()) {
            list.add(new ChemTheoryDto(task));
        }
        return list.get(new Random().nextInt(list.size()));
    }
}
