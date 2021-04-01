package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTask;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTaskExample;
import com.chemcool.school.lesson.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.lesson.tasks.chemmatches.service.ChemMatchingTaskService;
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

    private List<CoupleForMatching> list;

    @BeforeEach
    void setUp() {
        chemMatchingTaskExampleForTest = new ChemMatchingTaskExample
                ("description", "rightAnswer", 1, 1,
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
    void findMatchesByChapter() throws Exception {
        Integer chapterId = chemMatchingTaskExampleForTest.getChapterId();
        Mockito.when(service.getAllByChapterId(chapterId)).thenReturn(chemMatchingTasks);
        this.mockMvc.perform(
                get("/v1.0/findMatchesByChapter").param("chapter", String.valueOf(chapterId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].chapterId").value(chapterId))
                .andDo(print());
    }

    @Test
    void findMatchesByReferences() throws Exception {
        Integer referenceId = chemMatchingTaskExampleForTest.getReferenceId();
        Mockito.when(service.getAllByReferenceId(referenceId)).thenReturn(chemMatchingTasks);
        this.mockMvc.perform(
                get("/v1.0/findMatchesByReferences").param("references", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].referenceId").value(referenceId))
                .andDo(print());
    }
}