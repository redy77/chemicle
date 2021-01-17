package com.chemcool.school.tasks.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ChemistrySingleSelectTaskTest {

    public ChemistrySingleSelectTaskExample example;
    ChemistrySingleSelectTask task;

    @BeforeEach
    public void init(){
        example = new ChemistrySingleSelectTaskExample(
                "Сложным веществом является ...",
                "оксид натрия",
                "2",
                TypeOfTask.SINGLE_SELECT,
                "натрий",
                "кислород",
                "водород"
        );
        task = ChemistrySingleSelectTask.createChemistrySingleSelectTask(example);
    }

    @Test
    void createChemistrySingleSelectTask() {
        assertNotEquals("", task.getChemistrySingleSelectTaskUuid());
    }


    @Test
    void getDescription() {
       assertEquals("Сложным веществом является ...", task.getDescription());
    }

    @Test
    void getRightAnswer() {
        assertEquals("оксид натрия", task.getRightAnswer());
    }

    @Test
    void getChapterId() {
        assertEquals("2", task.getChapterId());
    }

    @Test
    void getTypeOfTask() {
        assertEquals(TypeOfTask.SINGLE_SELECT, task.getTypeOfTask());
    }

    @Test
    void getIncorrectAnswer1() {
        assertEquals("натрий", task.getIncorrectAnswer1());
    }

    @Test
    void getIncorrectAnswer2() {
        assertEquals("кислород", task.getIncorrectAnswer2());
    }

    @Test
    void getIncorrectAnswer3() {
        assertEquals("водород", task.getIncorrectAnswer3());
    }

    @Test
    void setChemistrySingleSelectTaskUuid() {
        String id = UUID.randomUUID().toString();
        task.setChemistrySingleSelectTaskUuid(id);
        assertEquals(id, task.getChemistrySingleSelectTaskUuid());
    }

    @Test
    void setDescription() {
        String test = "Microservice наше тестовое поле";
        task.setDescription(test);
        assertEquals(test, task.getDescription());
    }

    @Test
    void setRightAnswer() {
        String test = "Microservice наше тестовое поле";
        task.setRightAnswer(test);
        assertEquals(test, task.getRightAnswer());
    }

    @Test
    void setChapterId() {
        String test = "3";
        task.setChapterId(test);
        assertEquals(test, task.getChapterId());
    }

    @Test
    void setTypeOfTask() {
        task.setTypeOfTask(TypeOfTask.FIXED_ANSWER);
        assertEquals(TypeOfTask.FIXED_ANSWER, task.getTypeOfTask());
    }

    @Test
    void setIncorrectAnswer1() {
        String test = "Microservice наше тестовое поле";
        task.setIncorrectAnswer1(test);
        assertEquals(test, task.getIncorrectAnswer1());
    }

    @Test
    void setIncorrectAnswer2() {
        String test = "Microservice наше тестовое поле";
        task.setIncorrectAnswer2(test);
        assertEquals(test, task.getIncorrectAnswer2());
    }

    @Test
    void setIncorrectAnswer3() {
        String test = "Microservice наше тестовое поле";
        task.setIncorrectAnswer3(test);
        assertEquals(test, task.getIncorrectAnswer3());
    }
}