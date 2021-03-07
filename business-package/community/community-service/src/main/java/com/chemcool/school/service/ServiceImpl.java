package com.chemcool.school.service;

import com.chemcool.school.dto.GotFromFrontEnd;
import com.chemcool.school.entities.Comment;
import com.chemcool.school.entities.Lesson;
import com.chemcool.school.repo.CommentRepo;
import com.chemcool.school.repo.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ServiceImpl implements ServiceInterface {

    LessonRepo lessonRepo;
    CommentRepo commentRepo;

    @Autowired
    public ServiceImpl(LessonRepo lessonRepo, CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
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
    public void delComment(Long lessonId, Long commentId) {
        Lesson lesson = lessonRepo.getOne(lessonId);
        List<Comment> list = lesson.getComments();
//        list.removeIf(x-> commentRepo.existsById(commentId));

        Iterator<Comment> i = list.iterator();

        while(i.hasNext()) {
            Comment c = i.next();
            if (c.getId()==commentId) {
                i.remove();
            }
        }

        lesson.setComments(list);
        lessonRepo.save(lesson);
        commentRepo.deleteById(commentId);
    }

    @Transactional
    @Override
    public Comment findCommentById(Long commentId) {
        return commentRepo.findById(commentId).get();
    }

    @Transactional
    @Override
    public List<Lesson> findAllLessons() {
        return lessonRepo.findAll();
    }

    @Transactional
    @Override
    public Lesson getLesson(Long lessonId) {
        return lessonRepo.findById(lessonId).get();
    }


}
