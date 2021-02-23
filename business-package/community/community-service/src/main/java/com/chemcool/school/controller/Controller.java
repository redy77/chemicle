package com.chemcool.school.controller;

import com.chemcool.school.dto.GotFromFrontEnd;
import com.chemcool.school.entities.Comment;
import com.chemcool.school.entities.Lesson;
import com.chemcool.school.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    ServiceInterface serviceInterface;

    @GetMapping("/api/getcomments/{lesson_id}")
    public ResponseEntity<List<Comment>> getLesssonWithAllComments(@PathVariable Long lesson_id){
        Lesson lesson = serviceInterface.getLesson(lesson_id);
        return new ResponseEntity<>(lesson.getComments(), HttpStatus.OK);
    }
}
