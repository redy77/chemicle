package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTask;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTaskExample;
import com.chemcool.school.lesson.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.lesson.tasks.chemmatches.service.ChemMatchingTaskService;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = LessonApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@TestPropertySource("/application-test.properties")
class ChemMatchesRestControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ChemMatchesRestController controller;

    private List<ChemMatchingTask> chemMatchingTasks;

    @MockBean
    private ChemMatchingTaskService service;

    private ChemMatchingTaskExample chemMatchingTaskExampleForTest;

    @BeforeEach
    void setUp() {
        chemMatchingTaskExampleForTest = new ChemMatchingTaskExample
                ("description", "description", 1, 1,
                        Collections.singletonList(new CoupleForMatching("1", "2")));
        chemMatchingTasks = Collections.singletonList(ChemMatchingTask
                .createChemistryMatchingTask(chemMatchingTaskExampleForTest));
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @DisplayName("Получение задач по главе")
    void findMatchesByChapter() throws Exception {
        Integer chapterId = chemMatchingTaskExampleForTest.getChapterId();
        Mockito.when(service.getAllByChapterId(chapterId)).thenReturn(chemMatchingTasks);
        this.mockMvc.perform(
                get("/v1.0/findMatchesTaskByChapterId").param("chapterId", String.valueOf(chapterId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].chapterId").value(chapterId))
                .andDo(print());
    }

    @Test
    @DisplayName("Получение задач по разделу")
    void findMatchesByReferences() throws Exception {
        Integer referenceId = chemMatchingTaskExampleForTest.getReferenceId();
        Mockito.when(service.getAllByReferenceId(referenceId)).thenReturn(chemMatchingTasks);
        this.mockMvc.perform(
                get("/v1.0/findMatchesTaskByReferenceId").param("referenceId", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].referenceId").value(referenceId))
                .andDo(print());
    }

    @Test
    @DisplayName("Получение задач по главе и разделу")
    void findMatchesByChapterAndReferences() throws Exception {
        Integer chapterId = chemMatchingTaskExampleForTest.getChapterId();
        Integer referenceId = chemMatchingTaskExampleForTest.getReferenceId();
        Mockito.when(service.getAllByReferenceIdAndChapterId(referenceId, chapterId)).thenReturn(chemMatchingTasks);
        this.mockMvc.perform(
                get("/v1.0/findMatchesTaskByReferenceIdAndChapterId").param("chapterId", String.valueOf(chapterId))
                        .param("referenceId", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].chapterId").value(chapterId))
                .andExpect(jsonPath("$[0].referenceId").value(referenceId))
                .andDo(print());
    }

    @Test
    @DisplayName("Проверка на несуществующие главу или раздел")
    void findMatchesByFakeChapterAndReferences() throws Exception {
        Integer chapterId = 5;
        Integer referenceId = 5;
        Mockito.when(service.getAllByReferenceIdAndChapterId(referenceId, chapterId)).thenReturn(Collections.emptyList());
        this.mockMvc.perform(
                get("/v1.0/findMatchesTaskByReferenceIdAndChapterId").param("chapterId", String.valueOf(chapterId))
                        .param("referenceId", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*").value(IsEmptyCollection.empty()))
                .andDo(print());
    }
}