package com.chemcool.school.lesson.tasks.chemequations.service;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTaskExample;
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
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = LessonApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class ChemEquationsTaskProxyServiceUnitTest {

    @Autowired
    private ChemEquationsTaskProxyService proxyService;

    @MockBean
    private ChemEquationsTaskService service;

    private List<ChemEquationsTask> taskList = new ArrayList<>();

    private String id;
    private Integer i;

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
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(proxyService).isNotNull();
    }

    @Test
    void getById() {
        Mockito.when(service.getById(id)).thenReturn(Optional.ofNullable(taskList.get(i)));
        ChemEquationsTask task = proxyService.getById(id).orElse(null);
        assertThat(task).isNotNull();
        assertThat(task.getDescription()).isEqualTo("description");
    }

    @Test
    void getByFakeId() {
        Mockito.when(service.getById(id)).thenReturn(java.util.Optional.ofNullable(taskList.get(0)));
        ChemEquationsTask task = proxyService.getById(id + "1").orElse(null);
        assertThat(task).isNull();
    }

    @Test
    void getAll() {
        Mockito.when(service.getAll()).thenReturn(taskList);
        List<ChemEquationsTask> taskExamples = proxyService.getAll();
        assertThat(taskExamples).isNotNull();
    }

    @Test
    void getAllByChapterId() {
        Mockito.when(service.getAllByChapterId(1)).thenReturn(taskList.subList(0, 2));
        List<ChemEquationsTask> taskExamples = proxyService.getAllByChapterId(1);
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(2);
    }

    @Test
    void getAllByReferenceId() {
        Mockito.when(service.getAllByReferenceId(2)).thenReturn(taskList.subList(1, 3));
        List<ChemEquationsTask> taskExamples = proxyService.getAllByReferenceId(2);
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(2);
    }


    @Test
    void getAllByChapterIdAndReferenceId() {
        Mockito.when(service.getAllByChapterIdAndReferenceId(1, 2)).thenReturn(taskList.subList(1, 2));
        List<ChemEquationsTask> taskExamples = proxyService.getAllByChapterIdAndReferenceId(1, 2);
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(1);
    }

    @Test
    void checkAnswer() {
        boolean[] result = new boolean[]{true, true, true, true};
        Mockito.when(service.checkAnswer(id, "rightAnswer")).thenReturn(result);
        result = proxyService.checkAnswer(id, "rightAnswer");
        assertThat(result).isNotNull();
        assertThat(result).hasSize(4);
    }
}