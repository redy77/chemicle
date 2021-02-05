package com.chemcool.school.tasks.chemfixedanswer.web.api.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskExample;
import com.chemcool.school.tasks.chemfixedanswer.service.ChemFixedAnswerTaskService;
import com.chemcool.school.tasks.chemfixedanswer.web.api.dto.ChemFixedAnswerTaskDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChemistryFixedAnswerTaskServiceLayer {

    private final ChemFixedAnswerTaskService service;

    public List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerDto () {
        List<ChemFixedAnswerTaskDto> list = new ArrayList<>();
        for(ChemFixedAnswerTask task : service.getAll()){
            list.add(new ChemFixedAnswerTaskDto(task));
        }
        return list;
    }

    public Optional<ChemFixedAnswerTask> getFixedAnswerTaskById(String id) {
        return service.getById(id);
    }

    public String createNewFixedAnswerTask(ChemFixedAnswerTaskDto taskDto){
        return service.add(
                new ChemFixedAnswerTaskExample(
                        taskDto.getDescription(),
                        taskDto.getRightAnswer(),
                        taskDto.getChapterId(),
                        taskDto.getChapterId()
                )
        );
    }

//    public void updateFixedAnswerTask(ChemFixedAnswerTaskDto taskDto){
//        service.update(
//                new ChemFixedAnswerTask(
//                        taskDto.getTaskId(),
//                        taskDto.getDescription(),
//                        taskDto.getRightAnswer(),
//                        taskDto.getChapterId(),
//                        taskDto.getChapterId()
//                )
//        );
//    }

    public void deleteFixedAnswerTask(String id){
        service.deleteById(id);
    }
}
