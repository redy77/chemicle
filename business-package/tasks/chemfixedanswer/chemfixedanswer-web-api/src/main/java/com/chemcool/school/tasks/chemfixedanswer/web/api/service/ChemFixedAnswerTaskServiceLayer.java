package com.chemcool.school.tasks.chemfixedanswer.web.api.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskExample;
import com.chemcool.school.tasks.chemfixedanswer.service.ChemFixedAnswerTaskProxyService;
import com.chemcool.school.tasks.chemfixedanswer.web.api.dto.ChemFixedAnswerTaskDto;
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

    public Optional<ChemFixedAnswerTask> getFixedAnswerTaskById(String id) {
        return proxyService.getById(id);
    }

    public String createNewFixedAnswerTask(ChemFixedAnswerTaskDto taskDto){
        return proxyService.add(
                new ChemFixedAnswerTaskExample(
                        taskDto.getDescription(),
                        taskDto.getRightAnswer(),
                        taskDto.getChapterId(),
                        taskDto.getReferenceId()
                )
        );
    }

    public void updateFixedAnswerTask(ChemFixedAnswerTaskDto taskDto){
        proxyService.update(
                new ChemFixedAnswerTask(
                        taskDto.getTaskId(),
                        taskDto.getDescription(),
                        taskDto.getRightAnswer(),
                        taskDto.getChapterId(),
                        taskDto.getReferenceId()
                )
        );
    }

    public void deleteFixedAnswerTask(String id){
        proxyService.deleteById(id);
    }
}
