package com.chemcool.school.tasks.domain;

import com.chemcool.school.tasks.exeption.ChemistrySingleSelectTaskFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistrySingleSelectTaskFactory {

    public static ChemistrySingleSelectTask createTask(ChemistrySingleSelectTaskExample example){
        //  Тут проверки на условия при создания задач
        //  new ChemistrySingleSelectTaskFormatException("Описание ошибки");
        //

        log.info("Попытка создать задачу с ВЫБОРОМ ФИКСИРОВАННОГО ОТВЕТА");
        return ChemistrySingleSelectTask.createChemistrySingleSelectTask(example);
    }
}
