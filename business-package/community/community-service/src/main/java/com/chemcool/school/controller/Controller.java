package com.chemcool.school.controller;

import com.chemcool.school.entities.Comment;
import com.chemcool.school.entities.Lesson;
import com.chemcool.school.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    ServiceInterface serviceInterface;

    @GetMapping("/api/getcomments/{lesson_id}")
    public ResponseEntity<List<Comment>> getLesssonWithAllComments(@PathVariable Long lesson_id) {
        Lesson lesson = serviceInterface.getLesson(lesson_id);
        return new ResponseEntity<>(lesson.getComments(), HttpStatus.OK);
    }

    @GetMapping("/api/getlessons")
    public ResponseEntity<List<Lesson>> getAllLesssons() {
        List<Lesson> lessons = serviceInterface.findAllLessons();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @DeleteMapping(value = "/del/{lesson_id}/{comment_id}")
    public ResponseEntity<Long> delUser(@PathVariable Long lesson_id, @PathVariable Long comment_id) {
        if (serviceInterface.findCommentById(comment_id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            serviceInterface.delComment(lesson_id, comment_id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
