package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskExample;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTask;
import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTaskExample;
import com.chemcool.school.lesson.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.lesson.tasks.chemmatches.service.ChemistryMatchingTaskService;
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
class ChemMatchesRestControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ChemMatchesRestController controller;

    private List<ChemistryMatchingTask> chemistryMatchingTasks;

    @MockBean
    private ChemistryMatchingTaskService service;

    private ChemistryMatchingTaskExample chemistryMatchingTaskExampleForTest;

    private List<CoupleForMatching> list;

    @BeforeEach
    void setUp() {
        chemistryMatchingTaskExampleForTest = new ChemistryMatchingTaskExample
                ("description", "rightAnswer", 1, 1,
                        Collections.singletonList(new CoupleForMatching("1", "2")));
        chemistryMatchingTasks = Collections.singletonList(ChemistryMatchingTask
                .createChemistryMatchingTask(chemistryMatchingTaskExampleForTest));
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void findMatchesByChapter() throws Exception {
        Integer chapterId = chemistryMatchingTaskExampleForTest.getChapterId();
        Mockito.when(service.findTaskByChapter(chapterId)).thenReturn(chemistryMatchingTasks);
        this.mockMvc.perform(
                get("/v1.0/findMatchesByChapter").param("chapter", String.valueOf(chapterId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].chapterId").value(chapterId))
                .andDo(print());
    }

    @Test
    void findMatchesByReferences() throws Exception {
        Integer referenceId = chemistryMatchingTaskExampleForTest.getReferenceId();
        Mockito.when(service.findTaskByReferences(referenceId)).thenReturn(chemistryMatchingTasks);
        this.mockMvc.perform(
                get("/v1.0/findMatchesByReferences").param("references", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].referenceId").value(referenceId))
                .andDo(print());
    }
}