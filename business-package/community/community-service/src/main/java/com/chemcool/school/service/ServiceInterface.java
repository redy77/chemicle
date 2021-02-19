package com.chemcool.school.service;

import com.chemcool.school.entities.Comment;

import java.util.List;

public interface ServiceInterface {

    List<Comment> listByLesson (Long lessonId);

    void addLesson(String lessonName);

    void addComment(String comment, String author, String data, Long lessonId);

}
