package com.chemcool.school.tasks.fixedanswer.domain;

import com.chemcool.school.tasks.fixedanswer.exception.ChemistryFixedAnswerTaskException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistryFixedAnswerTaskFactory {
    public static ChemistryFixedAnswerTask createChemistryFixedAnswerTask(ChemistryFixedAnswerTaskExample example){

        if(example.getRightAnswer().equals("")){
            throw new ChemistryFixedAnswerTaskException("Ошибка! Поле " + "Правильный ответ " + "не может быть пустым");
        }
        if (Integer.getInteger(example.getChapterId()) < 1 || Integer.getInteger(example.getChapterId()) > 4) {
            throw new ChemistryFixedAnswerTaskException("Ошибка! Поле " + "Глава " + "имеет значение от 1 до 4 ");
        }

        log.info("Попытка создать урок " + example.getTypeOfTask());
        return ChemistryFixedAnswerTask.createChemistryFixedAnswerTask(example);
    }
}
