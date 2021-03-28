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
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LessonApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class ChemEquationsTaskProxyServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ChemEquationsTaskProxyService proxyService;

    @MockBean
    private ChemEquationsTaskService service;

    private ChemEquationsTaskExample taskExample;

    private String id;

    @BeforeEach
    void setUp() {
        taskExample = new ChemEquationsTaskExample(
                "uuid",
                "rightAnswer",
                1,
                1
        );
        System.out.println(taskExample);
        System.out.println("*******************");
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(proxyService).isNotNull();
    }

    @Test
    void add() {
        Mockito.when(service.save(taskExample)).thenReturn(taskExample.getTaskId());
       id = proxyService.add(taskExample);
        System.out.println(id);
        assertThat(id).isNotNull();
        //assertThat(taskExample.getTaskId()).isEqualTo(id);
    }

    @Test
    void update() {
    }

    @Test
    void getById() {
        ChemEquationsTask task = proxyService.getById(id).orElse(null);
        System.out.println("*********************"+task);
       // assertThat(task).isNotNull();
       // assertThat(task.getDescription()).isEqualTo("Выберите правильные пары");
    }

    @Test
    void getAll() {
    }

    @Test
    void getAllByChapterId() {
    }

    @Test
    void deleteById() {
    }
}