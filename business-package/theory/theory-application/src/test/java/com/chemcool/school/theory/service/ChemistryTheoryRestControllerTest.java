package com.chemcool.school.theory.service;

import com.chemcool.school.theory.app.TheoryApplication;
import com.chemcool.school.theory.web.api.dto.TheoryDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TheoryApplication.class)
@Testcontainers
@AutoConfigureMockMvc
public class ChemistryTheoryRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createLessonExampleTest() throws Exception {
        TheoryDto theoryDto =
                new TheoryDto("1", "theoryName", "theoryDescription", 1, 1);

        mockMvc.perform(post("/v1.0/lessons/create")
                .content(objectMapper.writeValueAsString(theoryDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is2xxSuccessful());
    }

    @Test
    void updateLessonExample() {

    }

}

