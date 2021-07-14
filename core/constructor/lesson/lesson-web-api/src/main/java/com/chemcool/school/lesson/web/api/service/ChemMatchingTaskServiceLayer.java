package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.domain.fixedanswer.ChemFixedAnswerTask;
import com.chemcool.school.lesson.domain.matches.ChemMatchingTask;
import com.chemcool.school.lesson.exception.matches.ChemMatchingTaskException;
import com.chemcool.school.lesson.service.matches.ChemMatchingTaskProxyService;
import com.chemcool.school.lesson.web.api.dto.ChemFixedAnswerTaskDto;
import com.chemcool.school.lesson.web.api.dto.ChemMatchingTaskDto;
import com.chemcool.school.lesson.web.api.exeption.ChemTaskEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ChemMatchingTaskServiceLayer {

    private final ChemMatchingTaskProxyService service;

    public ChemMatchingTaskDto getTaskDtoByIdDto(String id) {
        return service.getById(id).map(ChemMatchingTaskDto::new).orElse(null);
    }

    public List<ChemMatchingTaskDto> getAllTasksDto() {
        List<ChemMatchingTaskDto> list = new ArrayList<>();
        for (ChemMatchingTask task : service.getAll()) {
            list.add(new ChemMatchingTaskDto(task));
        }
        return list;
    }
    public List<ChemMatchingTaskDto> getAllTasksByReferenceIdDto(Integer referenceId) {
        List<ChemMatchingTaskDto> list = new ArrayList<>();
        for (ChemMatchingTask task : service.getAllByReferenceId(referenceId)) {
            list.add(new ChemMatchingTaskDto(task));
        }
        return list;
    }

    public List<ChemMatchingTaskDto> getAllTasksByChapterIdDto(Integer chapterId) {
        List<ChemMatchingTaskDto> list = new ArrayList<>();
        for (ChemMatchingTask task : service.getAllByChapterId(chapterId)) {
            list.add(new ChemMatchingTaskDto(task));
        }
        return list;
    }

    public List<ChemMatchingTaskDto> getAllTasksByReferenceIdAndChapterIdDto(Integer referenceId, Integer chapterId) {
        List<ChemMatchingTaskDto> list = new ArrayList<>();
        for (ChemMatchingTask task : service.getAllByReferenceIdAndChapterId(referenceId, chapterId)) {
            list.add(new ChemMatchingTaskDto(task));
        }
        return list;
    }

    public List<ChemMatchingTaskDto> getAllTasks() {
        List<ChemMatchingTaskDto> list = new ArrayList<>();
        for(ChemMatchingTask task : service.getAll()){
            list.add(new ChemMatchingTaskDto(task));
        }
        return list;
    }

    public ChemMatchingTaskDto getTaskDtoById(String uuid) {
        ChemMatchingTask task = service.getById(uuid).orElseThrow(
                () -> new ChemMatchingTaskException("Задание не найдено."));
        return new ChemMatchingTaskDto(task);
    }

    public ChemMatchingTaskDto getRandomChemMatchingTaskDto() {
        List<ChemMatchingTaskDto> list = new ArrayList<>();
        for (ChemMatchingTask task : service.getAll()) {
            list.add(new ChemMatchingTaskDto(task));
        }
        return list.get(new Random().nextInt(list.size()));
    }
}
