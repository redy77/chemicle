package com.chemcool.school.tasks.singleselectquestion.service;

import com.chemcool.school.tasks.domain.TypeOfTask;
import com.chemcool.school.tasks.singleselectquestion.domain.ChemistrySingleSelectTask;
import com.chemcool.school.tasks.singleselectquestion.domain.ChemistrySingleSelectTaskExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChemistrySingleSelectTaskServiceImplTest {

    private ArrayList<ChemistrySingleSelectTask> testBase = new ArrayList<>();

    @BeforeEach
    public void init(){
        testBase.add(
                new ChemistrySingleSelectTask(
                        "uuid-11111",
                        "Сложным веществом является ...",
                        "оксид натрия",
                        "2",
                        TypeOfTask.SINGLE_SELECT,
                        "натрий",
                        "кислород",
                        "водород"
                )
        );
        testBase.add(
                new ChemistrySingleSelectTask(
                        "uuid-22222",
                        "2Сложным веществом является ...",
                        "2оксид натрия",
                        "3",
                        TypeOfTask.SINGLE_SELECT,
                        "2натрий",
                        "2кислород",
                        "2водород"
                )
        );
        testBase.add(
                new ChemistrySingleSelectTask(
                        "uuid-33333",
                        "3Сложным веществом является ...",
                        "3оксид натрия",
                        "4",
                        TypeOfTask.SINGLE_SELECT,
                        "3натрий",
                        "3кислород",
                        "3водород"
                )
        );
    }

    @Test
    void add() {
        ChemistrySingleSelectTaskExample example = new ChemistrySingleSelectTaskExample(
                "AddСложным веществом является ...",
                "Addоксид натрия",
                "1",
                TypeOfTask.SINGLE_SELECT,
                "Addнатрий",
                "Addкислород",
                "Addводород"
        );
        ChemistrySingleSelectTask task = ChemistrySingleSelectTask.createChemistrySingleSelectTask(example);
        testBase.add(task);
        assertEquals(task.getRightAnswer(),testBase.get(3).getRightAnswer());
    }

    @Test
    void getById() {
        assertEquals("uuid-11111", testBase.get(0).getChemistrySingleSelectTaskUuid());
    }

    @Test
    void getAll() {
        assertEquals("uuid-11111", testBase.get(0).getChemistrySingleSelectTaskUuid());
        assertEquals("uuid-22222", testBase.get(1).getChemistrySingleSelectTaskUuid());
        assertEquals("uuid-33333", testBase.get(2).getChemistrySingleSelectTaskUuid());
    }

    @Test
    void getAllByChapterId() {
        assertEquals("2", testBase.get(0).getChapterId());
    }

    @Test
    void update() {
        testBase.get(1).setIncorrectAnswer1("Wrong wrong");
        assertEquals("Wrong wrong", testBase.get(1).getIncorrectAnswer1());
    }

    @Test
    void deleteById() {
        testBase.remove(0);
        assertNotEquals(testBase.get(0).getChemistrySingleSelectTaskUuid(), "uuid-11111");
    }
}