package com.chemcool.school.tasks.service.chemfixedanswer;




import com.chemcool.school.tasks.domain.chemequations.ChemEquationsTask;
import com.chemcool.school.tasks.domain.chemfixedanswer.ChemFixedAnswerTask;
import com.chemcool.school.tasks.domain.chemfixedanswer.ChemFixedAnswerTaskExample;
import com.chemcool.school.tasks.dto.chemequations.ChemEquationsTaskDto;
import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskCreateDto;
import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskDto;
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

    public String createNewFixedAnswerTask(ChemFixedAnswerTaskCreateDto taskDto){
        return proxyService.add(
                new ChemFixedAnswerTaskExample(
                        taskDto.getDescription(),
                        taskDto.getRightAnswer(),
                        taskDto.getChapterId(),
                        taskDto.getReferenceId()
                )
        );
    }

    public void updateFixedAnswerTask(ChemFixedAnswerTaskCreateDto taskDto){
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

    public boolean checkAnswer(String taskId, String userAnswer) {
        return proxyService.checkAnswer(taskId, userAnswer.replaceAll(" ", ""));
    }

    public List<ChemFixedAnswerTaskDto> getAllChemFixedAnswerTaskByChapterIdDto(int chapterId) {
        List<ChemFixedAnswerTaskDto> list = new ArrayList<>();
        for (ChemFixedAnswerTask task : proxyService.getAllByChapterId(chapterId)) {
            list.add(new ChemFixedAnswerTaskDto(task));
        }
        return list;
    }

    public List<ChemFixedAnswerTaskDto> getAllChemFixedAnswerTaskByChapterIdAndReferenceIdDto(int chapterId, int referenceId) {
        List<ChemFixedAnswerTaskDto> list = new ArrayList<>();
        for (ChemFixedAnswerTask task : proxyService.getAllByChapterIdAndReferenceId(chapterId, referenceId)) {
            list.add(new ChemFixedAnswerTaskDto(task));
        }
        return list;
    }
}
