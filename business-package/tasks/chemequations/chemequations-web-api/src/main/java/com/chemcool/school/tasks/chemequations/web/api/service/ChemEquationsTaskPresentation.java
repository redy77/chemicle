package com.chemcool.school.tasks.chemequations.web.api.service;


import com.chemcool.school.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.tasks.chemequations.web.api.dto.ChemEquationsTaskDto;

import com.chemcool.school.tasks.chemequations.web.api.exeption.ApiWebRestControllerExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис прослойка верхнего уровня содержащий бизнес логику CRUD операций
 * с полученным в ходе вычисления уравнения результатом
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@Service
@RequiredArgsConstructor
public class ChemEquationsTaskPresentation {

    private final ChemEquationsTaskServiceLayer serviceLayer;

    public List<ChemEquationsTaskDto> getAllChemistryEquationsDto() {
        return serviceLayer.getAllChemEquationsDto();
    }

    public Optional<ChemEquationsTask> getEquationsTaskById(String id) {
        return serviceLayer.getChemEquationsTaskById(id);
    }

    public String createNewEquationsTask(ChemEquationsTaskDto taskDto) {
        return serviceLayer.createNewChemEquationsTask(taskDto);
    }

    public void updateEquationsTask(ChemEquationsTaskDto taskDto) {
        serviceLayer.updateChemEquationsTask(taskDto);
    }

    public void deleteEquationsTask(String id) {
        serviceLayer.deleteChemEquationsTask(id);
    }

    public void checkAnswer(String taskId, String userAnswer) {
        boolean[] test = serviceLayer.checkAnswer(taskId, userAnswer);
        if (!test[0]) {
            new ApiWebRestControllerExceptionHandler();
            System.out.println("Ошибка 1");
        } else if (!test[1]) {
            new ApiWebRestControllerExceptionHandler();
            System.out.println("Ошибка 2");
        } else if (!test[2]) {
            new ApiWebRestControllerExceptionHandler();
            System.out.println("Ошибка 3");
        }

        if (!test[3]) {
            new ApiWebRestControllerExceptionHandler();
            System.out.println("Ошибка 4");
        }
    }
}