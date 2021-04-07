package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTaskExample;
import com.chemcool.school.lesson.theory.domain.ChemistryTheory;
import com.chemcool.school.lesson.theory.domain.ChemistryTheoryExample;
import com.chemcool.school.lesson.theory.service.ChemistryTheoryPageService;
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
class TheoryRestControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TheoryRestController controller;

    private List<ChemistryTheory> chemistryTheory;

    @MockBean
    private ChemistryTheoryPageService service;

    private ChemistryTheoryExample chemistryTheoryExampleForTest;

    @BeforeEach
    void setUp() {
        chemistryTheoryExampleForTest = new ChemistryTheoryExample("theoryName", "theoryDescription", 1, 1);
        chemistryTheory = Collections.singletonList(ChemistryTheory
                .createChemistryTheory(chemistryTheoryExampleForTest));
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void findTaskAndTheoryByChapter() throws Exception {
        Integer chapterId = chemistryTheoryExampleForTest.getTheoryExampleChapter();
        Mockito.when(service.findTheoryByChapter(chapterId)).thenReturn(chemistryTheory);
        this.mockMvc.perform(
                get("/v1.0/findTheoryByChapter").param("chapter", String.valueOf(chapterId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].theoryChapter").value(chapterId))
                .andDo(print());

    }

    @Test
    void findTaskAndTheoryByReferences() throws Exception {
        Integer referenceId = chemistryTheoryExampleForTest.getTheoryExampleReferences();
        Mockito.when(service.findTheoryByReferences(referenceId)).thenReturn(chemistryTheory);
        this.mockMvc.perform(
                get("/v1.0/findTheoryByReferences").param("references", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].theoryReferences").value(referenceId))
                .andDo(print());
    }
}