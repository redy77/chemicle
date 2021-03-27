package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.app.LessonApplication;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskExample;
import com.chemcool.school.lesson.tasks.chemfixedanswer.service.ChemFixedAnswerTaskService;
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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LessonApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@TestPropertySource("/application-test.properties")
@Sql(value = {"/testFixedAnswerDbCreate.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/testDbDrop.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ChemFixedAnswerRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ChemFixedAnswerRestController controller;

    @Test
    public void contextTest() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void findFixedAnswerTaskByChapter() throws Exception {
        Integer chapterId = 2;
        this.mockMvc.perform(
                get("/v1.0/findFixedAnswerTaskByChapter").param("chapter", String.valueOf(chapterId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(chapterId)))
                .andExpect(jsonPath("$[0].chapterId").value(chapterId))
                .andDo(print());
    }

    @Test
    void findFixedAnswerTaskByReferences() throws Exception {
        Integer referenceId = 4;
               this.mockMvc.perform(
                get("/v1.0/findFixedAnswerTaskByReferences").param("references", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                       .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                       .andExpect(jsonPath("$.*", hasSize(referenceId)))
                       .andExpect(jsonPath("$[0].referenceId").value(referenceId))
                       .andDo(print());
    }
}