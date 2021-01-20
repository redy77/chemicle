package com.chemcool.school.tasks.singleselectquestion.domain;

import com.chemcool.school.tasks.singleselectquestion.exeption.ChemistrySingleSelectTaskFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistrySingleSelectTaskFactory {

    public static ChemistrySingleSelectTask createTask(ChemistrySingleSelectTaskExample example){
        
        if (Integer.parseInt(example.getChapterIdExample()) < 1 || Integer.parseInt(example.getChapterIdExample()) > 4) {
            throw new ChemistrySingleSelectTaskFormatException("Уровень химии не может быть меньше 1 или больше 4.");
        }
        log.info("Попытка создать задачу с ВЫБОРОМ ФИКСИРОВАННОГО ОТВЕТА");
        return ChemistrySingleSelectTask.createChemistrySingleSelectTask(example);
    }
}
