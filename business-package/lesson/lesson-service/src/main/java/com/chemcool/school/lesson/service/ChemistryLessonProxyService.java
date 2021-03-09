package com.chemcool.school.lesson.service;

import com.chemcool.school.lesson.domain.*;
import com.chemcool.school.lesson.service.command.ChemistryLessonPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryLessonProxyService {
    private final ChemistryLessonEventNotificationService notificationService;
    private final ChemistryLessonPageService pageService;

    public String add(ChemistryLessonExample example){
        ChemistryLesson lesson = ChemistryLessonFactory.createLesson(example);
        notificationService.send(
                ChemistryLessonEventFactory.createEvent(lesson, ChemistryLessonEventType.CREATED)
        );
        return lesson.getLessonId();
    }

    public ChemistryLesson findTaskAndTheoryByChapter(int chapter){
       return pageService.findTaskAndTheoryByChapter(chapter);
    }

    public ChemistryLesson findTaskAndTheoryByReferences(int references){
        return pageService.findTaskAndTheoryByReferences(references);
    }
}
