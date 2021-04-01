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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LessonApplication.class)
@RunWith(SpringRunner.class)
@Transactional
@TestPropertySource("/application-test.properties")
@Sql(value = {"/testFixedAnswerDbCreate.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/testDbDrop.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ChemFixedAnswerTaskProxyServiceIntegrationTest {

    @Autowired
    private ChemFixedAnswerTaskProxyService proxyService;

    private String id;

    @BeforeEach
    void setUp() {
        id = "1";
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(proxyService).isNotNull();
    }

    @Test
    void getById() {
        ChemFixedAnswerTask task = proxyService.getById(id).orElse(null);
        System.out.println("*****************\n" + task + "\n*****************\n");
        assertThat(task).isNotNull();
        assertThat(task.getDescription()).isEqualTo("task1");
    }

    @Test
    void getByFakeId() {
        ChemFixedAnswerTask task = proxyService.getById(id + "1").orElse(null);
        System.out.println("*****************\n" + task + "\n*****************\n");
        assertThat(task).isNull();
    }

    @Test
    void getAll() {
        List<ChemFixedAnswerTask> taskExamples = proxyService.getAll();
        System.out.println("*****************\n" + taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(10);
    }

    @Test
    void getAllByChapterId() {
        List<ChemFixedAnswerTask> taskExamples = proxyService.getAllByChapterId(3);
        System.out.println("*****************\n" + taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(3);
    }
}