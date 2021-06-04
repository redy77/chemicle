package com.chemcool.school.tasks.chemFixedanswer;

import com.chemcool.school.tasks.app.TasksApplication;

import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TasksApplication.class)
@ContextConfiguration(classes = TasksApplication.class)
@AutoConfigureMockMvc
@Sql(value = {"/createtasks.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class CrudTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
//    @Autowired
//    private ChemFixedAnswerTaskRepository repository;

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
    public void contextLoad() throws Exception {
        //Проверка на работоспособность приложения и контроллера
        mockMvc.perform(get("/v1.0/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello!")));
    }

    @Test
    public void saveNewTask() throws Exception {
        //Пост запрос к контроллеру по адресу "/v.1.0/tasks/fixed-answer" для добавления задачи и получение результата ввиде ResultActions (Id)
        ResultActions resultActions = mockMvc.perform(post("/v1.0/")
                .content(objectMapper.writeValueAsString(chemFixedAnswerTaskDto1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
//        Optional<ChemFixedAnswerTask> chemFixedAnswerTask =
//                repository.findById(resultActions.andReturn().getResponse().toString());
//        assertThat(chemFixedAnswerTask.get().getTaskId()).isEqualTo(resultActions.andReturn().getResponse().toString());
    }

    @Test
    public void updateTask() throws Exception {
        ResultActions resultActions = mockMvc.perform(put("/v1.0")
                .content(objectMapper.writeValueAsString(chemFixedAnswerTaskDtoUpdate))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
//        Optional<ChemFixedAnswerTask> chemFixedAnswerTask =
//                repository.findById(resultActions.andReturn().getResponse().toString());
//        assertThat(new ChemFixedAnswerTaskDto(chemFixedAnswerTask.get())).isEqualTo(chemFixedAnswerTaskDtoUpdate);
    }


}
