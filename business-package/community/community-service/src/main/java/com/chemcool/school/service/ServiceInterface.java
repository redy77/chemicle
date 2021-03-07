package com.chemcool.school.service;

import com.chemcool.school.dto.GotFromFrontEnd;
import com.chemcool.school.entities.Comment;
import com.chemcool.school.entities.Lesson;

import java.util.List;


public interface ServiceInterface {

    void addLesson(String lessonName);

    Lesson getLesson(Long lessonId);

    void addComment(GotFromFrontEnd gotFromFrontEnd);

    void delComment(Long lessonId, Long commentId);

    Comment findCommentById(Long commentId);

    List<Lesson> findAllLessons();
}
