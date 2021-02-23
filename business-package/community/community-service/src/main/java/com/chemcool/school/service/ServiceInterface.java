package com.chemcool.school.service;

import com.chemcool.school.dto.GotFromFrontEnd;
import com.chemcool.school.entities.Lesson;


public interface ServiceInterface {

    void addLesson(String lessonName);

    Lesson getLesson(Long lessonId);

    void addComment(GotFromFrontEnd gotFromFrontEnd);
}
