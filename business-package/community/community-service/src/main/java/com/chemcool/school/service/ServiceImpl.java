package com.chemcool.school.service;

import com.chemcool.school.dto.GotFromFrontEnd;
import com.chemcool.school.entities.Comment;
import com.chemcool.school.entities.Lesson;
import com.chemcool.school.repo.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceImpl implements ServiceInterface {

    LessonRepo lessonRepo;

    @Autowired
    public ServiceImpl(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }

    @Override
    @Transactional
    public void addLesson(String lessonName) {
        lessonRepo.save(new Lesson(lessonName));
    }

    @Override
    @Transactional
    public void addComment(GotFromFrontEnd gotFromFrontEnd) {
        Lesson lesson = lessonRepo.getOne(gotFromFrontEnd.getLessonId());
        List<Comment> list = lesson.getComments();
        list.add(new Comment(gotFromFrontEnd.getComment(),
                gotFromFrontEnd.getAuthor(),
                gotFromFrontEnd.getDate()));
        lesson.setComments(list);
        lessonRepo.save(lesson);
    }

    @Transactional
    @Override
    public Lesson getLesson(Long lessonId) {
        return lessonRepo.findById(lessonId).get();
    }


}
