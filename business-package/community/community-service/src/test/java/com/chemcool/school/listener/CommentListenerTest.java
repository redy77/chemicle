package com.chemcool.school.listener;

import com.chemcool.school.dto.GotFromFrontEnd;
import com.chemcool.school.repo.LessonRepo;
import com.chemcool.school.service.ServiceInterface;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CommentListenerTest {

    private String comment = "Hello world!!!";
    private String comment_2 = "Life is good!!!";
    private String author = "Leo Ro";
    private String author_2 = "Steeve Ku";
    private String date = "7 July 2020";
    private String date_2 = "1 June 2021";
    private Long commentId = 1L;
    private Long commentId_2 = 2L;

    private Long lessonId = 1L;
    private String lessonName = "First lesson";
    private String lessonName2 = "Second lesson";
    private String lessonName3 = "Third lesson";
    private String lessonName4 = "Fourth lesson";

    @Autowired
    ServiceInterface serviceInterface;

    @Autowired
    KafkaTemplate<String, GotFromFrontEnd> kafkaTemplate;

    @Autowired
    private MockMvc mockMvc;

    //Перед запуском теста надо перевести ddl-auto в режим create

    @Test
    @Order(1)
    public void testAddLesson() {

        serviceInterface.addLesson(lessonName);
        serviceInterface.addLesson(lessonName2);
        serviceInterface.addLesson(lessonName3);
        serviceInterface.addLesson(lessonName4);
    }

    @Test
    @Order(2)
    public void testAddComment() {
        GotFromFrontEnd fromFrontEnd1 = new GotFromFrontEnd(comment, author, date, lessonId);
        kafkaTemplate.send("KafkaComment", fromFrontEnd1);
        GotFromFrontEnd fromFrontEnd2 = new GotFromFrontEnd(comment_2, author_2, date_2, lessonId);
        kafkaTemplate.send("KafkaComment", fromFrontEnd2);
    }

    @Test
    @Order(3)
    public void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(4)
    void getCommentsByLessonId() throws Exception {

        mockMvc.perform(
                get("/api/getcomments/{lessonId}", lessonId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(commentId))
                .andExpect(jsonPath("$[0].comment").value(comment))
                .andExpect(jsonPath("$[0].author").value(author))
                .andExpect(jsonPath("$[0].date").value(date))
                .andExpect(jsonPath("$[1].id").value(commentId_2))
                .andExpect(jsonPath("$[1].comment").value(comment_2))
                .andExpect(jsonPath("$[1].author").value(author_2))
                .andExpect(jsonPath("$[1].date").value(date_2));
    }

    @Test
    @Order(5)
    void deleteCommentById() throws Exception {
        mockMvc.perform(delete("/del/{lessonId}/{commentId}", lessonId, commentId))
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    void checkCommentIsDeleted() throws Exception {

        mockMvc.perform(
                get("/api/getcomments/{lessonId}", lessonId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(commentId_2))
                .andExpect(jsonPath("$[0].comment").value(comment_2))
                .andExpect(jsonPath("$[0].author").value(author_2))
                .andExpect(jsonPath("$[0].date").value(date_2));
    }

}