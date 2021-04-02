package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.app.LessonApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LessonApplication.class)
//(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = LessonApplication.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/testEquationsDbCreate.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/testDbDrop.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ChemEquationsRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ChemEquationsRestController controller;

    @Test
    public void contextTest() {
        assertThat(controller).isNotNull();
    }

    @Test
    void findEquationsTaskByChapter() throws Exception {
        Integer chapterId = 2;
        this.mockMvc.perform(
                get("/v1.0/findEquationsTaskByChapter").param("chapter", String.valueOf(chapterId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(chapterId)))
                .andExpect(jsonPath("$[0].chapterId").value(chapterId))
                .andDo(print());
    }

    @Test
    void findEquationsTaskByReferences() throws Exception {
        Integer referenceId = 4;
        this.mockMvc.perform(
                get("/v1.0/findEquationsTaskByReferences").param("references", String.valueOf(referenceId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(referenceId)))
                .andExpect(jsonPath("$[0].referenceId").value(referenceId))
                .andDo(print());
    }
}



























/*
 private String description;
    private String rightAnswer;
    private int chapterId;
    private int referenceId;
    public void addingTestTheoryDataBase(TheoryDto theoryDto) {
        presentation.createChemistryTheoryDto(theoryDto);
    }
 System.out.println(chemEquationsTaskExampleForTest);
        int chapterId = chemEquationsTaskExampleForTest.getChapterId();
        //addingChemEquationsTaskDataBase(chemEquationsTaskExampleForTest);
        //List<ChemEquationsTask> task = service.getAllByChapterId(chapterId);
       // assertThat(task).isNotNull();
        //System.out.println(task);

        System.out.println(chapterId);
       // mockMvc.perform(get(BASE_URL + "/findEquationsTaskByChapter?chapter={chapterId}", chapterId))
        //         .andExpect(status().isOk())
            //    .andReturn();

                //.andExpect(jsonPath("$.chapterId").value(chapterId))
        //.andExpect(jsonPath("$.description").value("description"))
        ;

          System.out.println(chemEquationsTaskExampleForTest);

        Mockito.when(service.add(Mockito.any())).thenReturn(chemEquationsTaskExampleForTest)


        System.out.println("Complete");
        int chapterId = chemEquationsTaskExampleForTest.getChapterId();
        System.out.println("*****************************888");
        System.out.println(objectMapper.writeValueAsString(chemEquationsTaskExampleForTest));
        mockMvc.perform(
                get(BASE_URL + "/findEquationsTaskByChapter?chapter={chapterId}", chapterId).
                        content(objectMapper.writeValueAsString(chemEquationsTaskExampleForTest))
                        .contentType(MediaType.APPLICATION_JSON)
                        )
        .andExpect(status().isNotFound())

                //.andExpect(status().isOk())
                ;
 */
