package com.chemcool.school.tasks.chemfixedanswer;

import com.chemcool.school.tasks.chemfixedanswer.app.ChemFixedAnswerTasksApplication;
import com.chemcool.school.tasks.chemfixedanswer.storage.ChemFixedAnswerTaskRepository;
import com.chemcool.school.tasks.chemfixedanswer.web.api.dto.ChemFixedAnswerTaskDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChemFixedAnswerTasksApplication.class)
@AutoConfigureMockMvc
@Sql(value = {"/db.migration/createtasks.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class CrudTestTwo {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    ChemFixedAnswerTaskDto chemFixedAnswerTaskDto1;
    ChemFixedAnswerTaskDto chemFixedAnswerTaskDto2;
    ChemFixedAnswerTaskDto chemFixedAnswerTaskDto3;
    ChemFixedAnswerTaskDto chemFixedAnswerTaskDtoUpdate;
    ChemFixedAnswerTaskDto chemFixedAnswerTaskDto4;

    @Before
    public void prepareForTest(){
        //Создание ДТО для тестирования записи данных
        chemFixedAnswerTaskDto1 =
                new ChemFixedAnswerTaskDto("1", "111", "111", 1, 1);
        chemFixedAnswerTaskDto2 =
                new ChemFixedAnswerTaskDto("2", "222", "222", 2, 2);
        chemFixedAnswerTaskDto3 =
                new ChemFixedAnswerTaskDto("3", "333", "333", 3, 3);
        chemFixedAnswerTaskDtoUpdate =
                new ChemFixedAnswerTaskDto("3", "123", "123", 3, 3);
         chemFixedAnswerTaskDto4 =
                new ChemFixedAnswerTaskDto("4", "444", "444", 4, 4);
    }

    @Test
    @Sql(value = {"/db.migration/createtasks.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void getTasks() throws Exception {
        List<ChemFixedAnswerTaskDto> list = new ArrayList<>();
        list.add(chemFixedAnswerTaskDto1);
        list.add(chemFixedAnswerTaskDto2);
        list.add(chemFixedAnswerTaskDto3);
        list.add(chemFixedAnswerTaskDto4);
        this.mockMvc.perform(get("/v.1.0/tasks/fixed-answer/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(objectMapper.writeValueAsString(list)))
                .andDo(print());
    }

    @Test
    public void getTaskById() throws Exception {
        mockMvc.perform(get("/v.1.0/tasks/fixed-answer/" + "2"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(objectMapper.writeValueAsString(chemFixedAnswerTaskDto2)))
                .andDo(print());
    }

    @Test
    public void deleteTask() throws Exception{
        mockMvc.perform(delete("/v.1.0/tasks/fixed-answer/"+"1"))
                .andExpect(status().is2xxSuccessful());
    }
}
