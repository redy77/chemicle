package com.chemcool.school.lesson.tasks.chemmatches.service;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTask;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTaskExample;
import com.chemcool.school.lesson.tasks.chemmatches.domain.CoupleForMatching;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LessonApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/testMatchesDbCreate.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/testDbDrop.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ChemistryMatchingTaskProxyServiceIntegrationTest {

    @Autowired
    private ChemistryMatchingTaskProxyService proxyService;

    private String id;

    @BeforeEach
    void setUp() {
        id = "1";
        assertThat(id).isNotNull();
        System.out.println("Создана задача с id: " + id);
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(proxyService).isNotNull();
    }

    @Test
    void getById() {
        ChemistryMatchingTask task = proxyService.getById(id).orElse(null);
        System.out.println("*****************\n"+task + "\n*****************\n");
        assertThat(task).isNotNull();
        assertThat(task.getDescription()).isEqualTo("task1");
    }

    @Test
    void getByFakeId() {
        ChemistryMatchingTask task = proxyService.getById(id+"1").orElse(null);
        System.out.println("*****************\n"+task + "\n*****************\n");
        assertThat(task).isNull();
    }

    @Test
    void getAll() {
        List<ChemistryMatchingTask> taskExamples = proxyService.getAll();
        System.out.println("*****************\n"+taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(10);
    }

    @Test
    void getAllByChapterId() {
        List<ChemistryMatchingTask> taskExamples = proxyService.getAllByChapterId(3);
        System.out.println("*****************\n"+taskExamples + "\n*****************\n");
        assertThat(taskExamples).isNotNull();
        assertThat(taskExamples).hasSize(3);
    }
}