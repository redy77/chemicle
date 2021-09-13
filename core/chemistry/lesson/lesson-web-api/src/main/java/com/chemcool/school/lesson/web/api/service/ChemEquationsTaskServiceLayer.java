package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.domain.equation.ChemEquationsTask;
import com.chemcool.school.lesson.service.equation.ChemEquationsTaskProxyService;
import com.chemcool.school.lesson.web.api.dto.ChemEquationsTaskDto;
import com.chemcool.school.lesson.web.api.exeption.ChemTaskEmptyException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
@AllArgsConstructor
public class ChemEquationsTaskServiceLayer {

    private final ChemEquationsTaskProxyService proxyService;

    public List<ChemEquationsTaskDto> getAllChemEquationsDto() {
        List<ChemEquationsTaskDto> list = new ArrayList<>();
        for (ChemEquationsTask task : proxyService.getAll()) {
            list.add(new ChemEquationsTaskDto(task));
        }
        return list;
    }

    public List<ChemEquationsTaskDto> getAllChemEquationsByChapterIdDto(Integer chapterId) {
        List<ChemEquationsTaskDto> list = new ArrayList<>();
        for (ChemEquationsTask task : proxyService.getAllByChapterId(chapterId)) {
            list.add(new ChemEquationsTaskDto(task));
        }
        return list;
    }

    public List<ChemEquationsTaskDto> getAllChemEquationsByReferenceIdDto(Integer referenceId) {
        List<ChemEquationsTaskDto> list = new ArrayList<>();
        for (ChemEquationsTask task : proxyService.getAllByReferenceId(referenceId)) {
            list.add(new ChemEquationsTaskDto(task));
        }
        return list;
    }

    public List<ChemEquationsTaskDto> getAllByReferenceIdAndChapterIdDto(Integer referenceId, Integer chapterId) {
        List<ChemEquationsTaskDto> list = new ArrayList<>();
        for (ChemEquationsTask task : proxyService.getAllByReferenceIdAndChapterId(referenceId, chapterId)) {
            list.add(new ChemEquationsTaskDto(task));
        }
        return list;
    }

    public ChemEquationsTaskDto getChemEquationsTaskById(String id) {
        ChemEquationsTask task = proxyService.getById(id)
                .orElseThrow(() -> new ChemTaskEmptyException("Задание не найдено."));
        return new ChemEquationsTaskDto(task);
    }


    public ChemEquationsTaskDto getRandomChemistryEquationsDto() {
        List<ChemEquationsTaskDto> list = new ArrayList<>();
        for (ChemEquationsTask task : proxyService.getAll()) {
            list.add(new ChemEquationsTaskDto(task));
        }
        return list.get(new Random().nextInt(list.size()));
    }
}
