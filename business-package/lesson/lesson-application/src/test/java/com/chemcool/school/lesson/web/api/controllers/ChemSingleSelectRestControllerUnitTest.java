package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTaskExample;
import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTaskExample;
import com.chemcool.school.lesson.tasks.chemsingleselect.service.ChemSingleSelectTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = LessonApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@TestPropertySource("/application-test.properties")
class ChemSingleSelectRestControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ChemSingleSelectRestController controller;

    private List<ChemSingleSelectTask> chemSingleSelectTask;

    @MockBean
    private ChemSingleSelectTaskService service;

    private ChemSingleSelectTaskExample chemSingleSelectTaskExampleForTest;
    @BeforeEach
    void setUp() {
        chemSingleSelectTaskExampleForTest = new ChemSingleSelectTaskExample("taskExampleDescription", "taskExampleCorrectAnswer",
                1, 1, "taskExampleIncorrectAnswerOne","taskExampleIncorrectAnswerTwo",
                "taskExampleIncorrectAnswerThree", "taskExampleIncorrectAnswerFour");
        chemSingleSelectTask = Collections.singletonList(ChemSingleSelectTask
                .createChemistrySingleSelectTask(chemSingleSelectTaskExampleForTest));
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void findTaskByChapter() throws Exception {
        Integer chapterId = chemSingleSelectTaskExampleForTest.getTaskExampleChapterId();
        Mockito.when(service.findTaskByChapter(chapterId)).thenReturn(chemSingleSelectTask);
        this.mockMvc.perform(
                get("/v1.0/findSingleSelectTaskByChapter").param("chapter", String.valueOf(chapterId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].chapterId").value(chapterId))
                .andDo(print());
    }

    @Test
    void findTaskByReferences() throws Exception {
        Integer referenceId = chemSingleSelectTaskExampleForTest.getTaskExampleReferenceId();
        Mockito.when(service.findTaskByReferences(referenceId)).thenReturn(chemSingleSelectTask);
        this.mockMvc.perform(
                get("/v1.0/findSingleSelectTaskByReferences").param("references", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].referenceId").value(referenceId))
                .andDo(print());
    }
}