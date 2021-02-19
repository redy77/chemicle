package com.chemcool.school.service;

import com.chemcool.school.entities.Comment;
import com.chemcool.school.entities.Lesson;
import com.chemcool.school.repo.CommentRepo;
import com.chemcool.school.repo.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceImpl implements ServiceInterface {
    LessonRepo lessonRepo;
    CommentRepo commentRepo;

    @Autowired
    public ServiceImpl(LessonRepo lessonRepo, CommentRepo commentRepo) {
        this.lessonRepo = lessonRepo;
        this.commentRepo = commentRepo;
    }

    @Override
    @Transactional
    public List<Comment> listByLesson(Long lessonId) {
        Lesson lesson= lessonRepo.getOne(lessonId);
        return lesson.getComments();
    }

    @Override
    @Transactional
    public void addLesson(String lessonName) {
        lessonRepo.save(new Lesson(lessonName));
    }

    @Override
    @Transactional
    public void addComment(String comment, String author, String data, Long lessonId) {
        Lesson lesson = lessonRepo.getOne(lessonId);
        commentRepo.save(new Comment(comment, author, data, lesson));

    }
}
