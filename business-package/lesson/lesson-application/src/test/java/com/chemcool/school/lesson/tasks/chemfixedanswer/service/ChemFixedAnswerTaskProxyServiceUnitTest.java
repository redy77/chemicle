package com.chemcool.school.lesson.tasks.chemfixedanswer.service;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LessonApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class ChemFixedAnswerTaskProxyServiceUnitTest {

    @Autowired
    private ChemFixedAnswerTaskProxyService proxyService;

    @MockBean
    private ChemFixedAnswerTaskService service;

    private List<ChemFixedAnswerTask> taskList = new ArrayList<>();

    private String id;
    private Integer i;

    @BeforeEach
    void setUp() {
        taskList.add(ChemFixedAnswerTask.createChemistryFixedAnswerTask(new ChemFixedAnswerTaskExample(
                "description",
                "rightAnswer",
                1,
                1
        )));
        taskList.add(ChemFixedAnswerTask.createChemistryFixedAnswerTask(new ChemFixedAnswerTaskExample(
                "another_description",
                "another_rightAnswer",
                1,
                2
        )));
        taskList.add(ChemFixedAnswerTask.createChemistryFixedAnswerTask(new ChemFixedAnswerTaskExample(
                "another_description",
                "another_rightAnswer",
                2,
                2
        )));
        System.out.println("*****************\n"+taskList + "\n*****************\n");
        i = 0; //Элемент листа, при значения !=0 тест getById должен падать
        id = taskList.get(i).getTaskId();
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(proxyService).isNotNull();
    }

    @Test
    void getById() {
        Mockito.when(service.getById(id)).thenReturn(Optional.ofNullable(taskList.get(i)));
        ChemFixedAnswerTask task = proxyService.getById(id).orElse(null);
        System.out.println("*****************\n"+task + "\n*****************\n");
        assertThat(task).isNotNull();
        assertThat(task.getDescription()).isEqualTo("description");
    }

    @Test
    void getByFakeId() {
        Mockito.when(service.getById(id)).thenReturn(Optional.ofNullable(taskList.get(0)));
        ChemFixedAnswerTask task = proxyService.getById(id + "1").orElse(null);
        System.out.println("*****************\n"+task + "\n*****************\n");
        assertThat(task).isNull();
    }

    @Test
    void getAll() {
        Mockito.when(service.getAll()).thenReturn(taskList);
        List<ChemFixedAnswerTask> taskExamples = proxyService.getAll();
        System.out.println("*****************\n"+taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(3);
    }

    @Test
    void getAllByChapterId() {
        Mockito.when(service.getAllByChapterId(2)).thenReturn(taskList.subList(0, 2));
        List<ChemFixedAnswerTask> taskExamples = proxyService.getAllByChapterId(2);
        System.out.println("*****************\n"+taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(2);
    }

    @Test
    void getAllByReferenceId() {
        Mockito.when(service.getAllByReferenceId(1)).thenReturn(taskList.subList(1, 3));
        List<ChemFixedAnswerTask> taskExamples = proxyService.getAllByReferenceId(1);
        System.out.println("*****************\n"+taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(2);
    }
}