package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskExample;
import com.chemcool.school.lesson.tasks.chemfixedanswer.service.ChemFixedAnswerTaskProxyService;
import com.chemcool.school.lesson.web.api.dto.ChemFixedAnswerTaskDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChemFixedAnswerTaskServiceLayer {

    private final ChemFixedAnswerTaskProxyService proxyService;

    public List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerDto () {
        List<ChemFixedAnswerTaskDto> list = new ArrayList<>();
        for(ChemFixedAnswerTask task : proxyService.getAll()){
            list.add(new ChemFixedAnswerTaskDto(task));
        }
        return list;
    }
    public List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerByReferenceIdDto (int referenceId) {
        List<ChemFixedAnswerTaskDto> list = new ArrayList<>();
        for(ChemFixedAnswerTask task : proxyService.getAllByReferenceId(referenceId)){
            list.add(new ChemFixedAnswerTaskDto(task));
        }
        return list;
    }

    public List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerByChapterIdDto (int chapterId) {
        List<ChemFixedAnswerTaskDto> list = new ArrayList<>();
        for(ChemFixedAnswerTask task : proxyService.getAllByChapterId(chapterId)){
            list.add(new ChemFixedAnswerTaskDto(task));
        }
        return list;
    }

    public List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerByReferenceIdAndChapterIdDto (int referenceId, int chapterId) {
        List<ChemFixedAnswerTaskDto> list = new ArrayList<>();
        for(ChemFixedAnswerTask task : proxyService.getAllByReferenceIdAndChapterId(referenceId, chapterId)){
            list.add(new ChemFixedAnswerTaskDto(task));
        }
        return list;
    }

    public Optional<ChemFixedAnswerTask> getFixedAnswerTaskById(String id) {
        return proxyService.getById(id);
    }

    public void deleteFixedAnswerTask(String id){
        proxyService.deleteById(id);
    }
}
