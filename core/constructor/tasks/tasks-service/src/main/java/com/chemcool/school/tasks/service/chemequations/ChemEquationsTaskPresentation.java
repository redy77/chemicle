package com.chemcool.school.tasks.service.chemequations;

import com.chemcool.school.tasks.dto.chemequations.ChemAnswerDto;
import com.chemcool.school.tasks.dto.chemequations.ChemEquationsTaskCreateDto;
import com.chemcool.school.tasks.dto.chemequations.ChemEquationsTaskDto;
import com.chemcool.school.tasks.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemEquationsTaskPresentation {

    private final ChemEquationsTaskServiceLayer serviceLayer;
    private final JWTParser jwtParser;

    public String createNewEquationsTask(ChemEquationsTaskCreateDto taskDto, String rightAnswer, String token) {
        jwtParser.checkRolesOnAdmin(token);
        return serviceLayer.createNewChemEquationsTask(taskDto);
    }

    public void updateEquationsTask(ChemEquationsTaskCreateDto taskDto) {
        serviceLayer.updateChemEquationsTask(taskDto);
    }

    public void deleteEquationsTask(String id) {
        serviceLayer.deleteChemEquationsTask(id);
    }

    public ChemAnswerDto checkAnswer(String taskId, String userAnswer) {
        boolean[] test = serviceLayer.checkAnswer(taskId, userAnswer);
        String[] result = new String[test.length];
        int score = 10;

        for (int i = 0; i < result.length; i++) {
            result[i] = "Тест" + (i + 1) + " пройден!";
        }

        if (!test[0]) {
            result[1] = result[1].replaceAll("пройден!", "не пройден! (-5) ");
            score -= 5;
        }
        if (!test[1]) {
            result[0] = result[0].replaceAll("пройден!", "не пройден! проверь регистр(-2)");
            score -= 2;
        }


        if (!test[2]) {
            result[2] = result[2].replaceAll("пройден!", "не пройден! Проверь агрегатное состояние елементов! (-2)");
            score -= 2;
        }

        if (!test[3]) {
            result[3] = result[3].replaceAll("пройден", "не пройден! Проверь вид реакции! (-1)");
            score -= 1;
        }
        return new ChemAnswerDto(test[0], result, score);
    }
}