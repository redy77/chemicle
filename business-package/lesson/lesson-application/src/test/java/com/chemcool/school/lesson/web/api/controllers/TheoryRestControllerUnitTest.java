package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.theory.domain.ChemTheory;
import com.chemcool.school.lesson.theory.domain.ChemTheoryExample;
import com.chemcool.school.lesson.theory.service.ChemTheoryPageService;
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
class TheoryRestControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TheoryRestController controller;

    private List<ChemTheory> chemTheory;

    @MockBean
    private ChemTheoryPageService service;

    private ChemTheoryExample chemTheoryExampleForTest;

    @BeforeEach
    void setUp() {
        chemTheoryExampleForTest = new ChemTheoryExample("theoryName", "theoryDescription", 1, 1);
        chemTheory = Collections.singletonList(ChemTheory
                .createChemistryTheory(chemTheoryExampleForTest));
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void contextTest() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void findTaskAndTheoryByChapter() throws Exception {
        Integer chapterId = chemTheoryExampleForTest.getTheoryExampleChapter();
        Mockito.when(service.getAllByChapterId(chapterId)).thenReturn(chemTheory);
        this.mockMvc.perform(
                get("/v1.0/findTheoryByChapter").param("chapterId", String.valueOf(chapterId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].theoryChapter").value(chapterId))
                .andDo(print());

    }

    @Test
    void findTaskAndTheoryByReferences() throws Exception {
        Integer referenceId = chemTheoryExampleForTest.getTheoryExampleReferences();
        Mockito.when(service.getAllByReferenceId(referenceId)).thenReturn(chemTheory);
        this.mockMvc.perform(
                get("/v1.0/findTheoryByReferences").param("referenceId", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].theoryReferences").value(referenceId))
                .andDo(print());
    }
}