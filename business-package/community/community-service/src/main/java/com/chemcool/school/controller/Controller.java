package com.chemcool.school.controller;

import com.chemcool.school.entities.Comment;
import com.chemcool.school.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    ServiceInterface serviceInterface;

    @GetMapping("/lesson/{lessonName}")
    public String addlesson(@PathVariable String lessonName) {
        serviceInterface.addLesson(lessonName);
        return "lesson added";
    }

    @GetMapping("/comment/{comment}/{author}/{date}/{id}")
    public String addcommment(@PathVariable String comment,
                              @PathVariable String author,
                              @PathVariable String date,
                              @PathVariable Long id) {
        serviceInterface.addComment(comment, author, date, id);
        return "comment added";
    }

    @GetMapping("/print/{id}")
    public String print(@PathVariable Long id) {
        List<Comment> list = serviceInterface.listByLesson(id);
        return list.stream().map(x->"{"+x.getComment()+", "+x.getAuthor()+"}").collect(Collectors.joining());
    }
}
