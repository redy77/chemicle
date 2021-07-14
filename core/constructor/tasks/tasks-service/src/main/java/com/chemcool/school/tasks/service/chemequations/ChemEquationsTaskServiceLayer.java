package com.chemcool.school.tasks.service.chemequations;

import com.chemcool.school.tasks.exception.chemequations.ChemTaskEmptyException;
import com.chemcool.school.tasks.domain.chemequations.ChemEquationsTask;
import com.chemcool.school.tasks.domain.chemequations.ChemEquationsTaskExample;
import com.chemcool.school.tasks.dto.chemequations.ChemEquationsTaskCreateDto;
import com.chemcool.school.tasks.dto.chemequations.ChemEquationsTaskDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ChemEquationsTaskServiceLayer {

    private final ChemEquationsTaskProxyService proxyService;


    public String createNewChemEquationsTask(ChemEquationsTaskCreateDto taskDto) {
        return proxyService.add(
                new ChemEquationsTaskExample(
                        taskDto.getTaskId(),
                        taskDto.getDescription(),
                        taskDto.getRightAnswer(),
                        taskDto.getChapterId(),
                        taskDto.getReferenceId()
                )
        );
    }

    public void updateChemEquationsTask(ChemEquationsTaskCreateDto taskDto) {
        proxyService.update(
                new ChemEquationsTask(
                        taskDto.getTaskId(),
                        taskDto.getDescription(),
                        taskDto.getRightAnswer(),
                        taskDto.getChapterId(),
                        taskDto.getReferenceId()
                )
        );
    }

    public void deleteChemEquationsTask(String id) {
        proxyService.deleteById(id);
    }

    public boolean[] checkAnswer(String taskId, String userAnswer) {
        return proxyService.checkAnswer(taskId, userAnswer.replaceAll(" ", ""));
    }
}
