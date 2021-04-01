package com.chemcool.school.lesson.tasks.chemsingleselect.service;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskExample;
import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTaskExample;
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
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*
Тест для ChemSingleSelectTaskProxyService. Вместо ChemSingleSelectTaskService заглушка
Создаем лист из трех тасок. Их подставляем в заглушку.
 */

@SpringBootTest(classes = LessonApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class ChemSingleSelectTaskProxyServiceUnitTest {

    @Autowired
    private ChemSingleSelectTaskProxyService proxyService;

    @MockBean
    private ChemSingleSelectTaskService service;

    private List<ChemSingleSelectTask> taskList = new ArrayList<>();

    private String id;
    private Integer i;

    @BeforeEach
    void setUp() {
        taskList.add(ChemSingleSelectTask.createChemistrySingleSelectTask(new ChemSingleSelectTaskExample(
                "description",
                "correctAnswer",
                1,
                1,
                "IncorrectAnswerOne",
                "IncorrectAnswerTwo",
                "IncorrectAnswerThree",
                "IncorrectAnswerFour"
        )));
        taskList.add(ChemSingleSelectTask.createChemistrySingleSelectTask(new ChemSingleSelectTaskExample(
                "another_description",
                "another_correctAnswer",
                1,
                2,
                "another_IncorrectAnswerOne",
                "another_IncorrectAnswerTwo",
                "another_IncorrectAnswerThree",
                "another_IncorrectAnswerFour"
        )));
        taskList.add(ChemSingleSelectTask.createChemistrySingleSelectTask(new ChemSingleSelectTaskExample(
                "another_description",
                "another_correctAnswer",
                2,
                2,
                "another_IncorrectAnswerOne",
                "another_IncorrectAnswerTwo",
                "another_IncorrectAnswerThree",
                "another_IncorrectAnswerFour"
        )));
        System.out.println("*****************\n"+taskList + "\n*****************\n");
        i = 0; //Элемент листа, при значения !=0 тест getById должен падать
        id = taskList.get(i).getTaskId();
        System.out.println("*****************\n"+id + "\n*****************\n");
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(proxyService).isNotNull();
    }

    @Test
    void getById() {
        Mockito.when(service.getById(id)).thenReturn(Optional.ofNullable(taskList.get(i)));
        ChemSingleSelectTask task = proxyService.getById(id).orElse(null);
        System.out.println("*****************\n"+task + "\n*****************\n");
        assertThat(task).isNotNull();
        assertThat(task.getDescription()).isEqualTo("description");
    }

    @Test
    void getByFakeId() {
        Mockito.when(service.getById(id)).thenReturn(Optional.ofNullable(taskList.get(i)));
        ChemSingleSelectTask task = proxyService.getById(id + "1").orElse(null);
        System.out.println("*****************\n"+task + "\n*****************\n");
        assertThat(task).isNull();
    }

    @Test
    void getAll() {
        Mockito.when(service.getAll()).thenReturn(taskList);
        List<ChemSingleSelectTask> taskExamples = proxyService.getAll();
        System.out.println("*****************\n"+taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).isEqualTo(taskList);
        assertThat(taskExamples).hasSize(3);
    }

    @Test
    void getAllByChapterId() {
        Mockito.when(service.getAllByChapterId(1)).thenReturn(taskList.subList(0, 2));
        List<ChemSingleSelectTask> taskExamples = proxyService.getAllByChapterId(1);
        System.out.println("*****************\n"+taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(2);
    }

    @Test
    void getAllByReferenceId() {
        Mockito.when(service.getAllByReferenceId(2)).thenReturn(taskList.subList(1, 3));
        List<ChemSingleSelectTask> taskExamples = proxyService.getAllByReferenceId(2);
        System.out.println("*****************\n"+taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(2);
    }
}