package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTaskExample;
import com.chemcool.school.lesson.tasks.chemequations.service.ChemEquationsTaskProxyService;
import com.chemcool.school.lesson.web.api.dto.ChemEquationsTaskDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LessonApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class ChemEquationsTaskServiceLayerTest {

    @MockBean
    private ChemEquationsTaskProxyService proxyService;

    private List<ChemEquationsTask> taskList = new ArrayList<>();

    private String id;
    private Integer i, referenceId, chapterId;

    @BeforeEach
    void setUp() {
        taskList.add(ChemEquationsTask.createChemEquationsTask(new ChemEquationsTaskExample(
                "description",
                "rightAnswer",
                1,
                1
        )));
        taskList.add(ChemEquationsTask.createChemEquationsTask(new ChemEquationsTaskExample(
                "another_description",
                "another_rightAnswer",
                1,
                2
        )));
        taskList.add(ChemEquationsTask.createChemEquationsTask(new ChemEquationsTaskExample(
                "another_description",
                "another_rightAnswer",
                2,
                2
        )));
        i = 0; //Элемент листа, при значения !=0 тест getById должен падать
        id = taskList.get(i).getTaskId();
        referenceId = 2;
        chapterId = 1;
    }

    @Test
    void getAllChemEquationsDto() {
        Mockito.when(proxyService.getAll()).thenReturn(taskList);
        List<ChemEquationsTaskDto> taskExamples = new ArrayList<>();
        for (ChemEquationsTask task : proxyService.getAll()) {
            taskExamples.add(new ChemEquationsTaskDto(task));
        }
        System.out.println("***********\n" + taskExamples + "\n***********\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(3);
        for (ChemEquationsTaskDto task : taskExamples) {
            assertThat(task.getTaskId()).isNotNull();
            assertThat(task.getChapterId()).isNotNull();
            assertThat(task.getReferenceId()).isNotNull();
        }
    }

    @Test
    void getAllChemEquationsByChapterIdDto() {
    }

    @Test
    void getAllChemEquationsByReferenceIdDto() {
    }

    @Test
    void getAllByReferenceIdAndChapterIdDto() {
    }

    @Test
    void getChemEquationsTaskById() {
    }
}