package com.chemcool.school.tasks.chemequations.web.api.service;

import com.chemcool.school.tasks.chemequations.web.api.dto.ChemEquationsTaskDto;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Сервис прослойка нижнего уровня содержащий бизнес логику CRUD операций
 * с полученным в ходе вычисления уравнения результатом
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@Service
@AllArgsConstructor
public class ChemEquationsTaskServiceLayer {

//    private final ChemEquationsTaskProxyService proxyService;
//
//    public List<ChemEquationsTaskDto> getAllChemEquationsDto() {
//        List<ChemEquationsTaskDto> list = new ArrayList<>();
//        for (ChemEquationsTask task : proxyService.getAll()) {
//            list.add(new ChemEquationsTaskDto(task));
//        }
//        return list;
//    }
//
//    public Optional<ChemEquationsTask> getChemEquationsTaskById(String id) {
//        return proxyService.getById(id);
//    }
//
//    public String createNewChemEquationsTask(ChemEquationsTaskDto taskDto) {
//        return proxyService.add(
//                new ChemEquationsTaskExample(
//                        taskDto.getDescription(),
//                        taskDto.getEquations(),
//                        taskDto.getRightAnswer(),
//                        taskDto.getChapterId(),
//                        taskDto.getReferenceId()
//                )
//        );
//    }
//
//    public void updateChemEquationsTask(ChemEquationsTaskDto taskDto) {
//        proxyService.update(
//                new ChemEquationsTask(
//                        taskDto.getTaskId(),
//                        taskDto.getDescription(),
//                        taskDto.getEquations(),
//                        taskDto.getRightAnswer(),
//                        taskDto.getChapterId(),
//                        taskDto.getReferenceId()
//                )
//        );
//    }
//
//    public void deleteChemEquationsTask(String id) {
//        proxyService.deleteById(id);
//    }
}
