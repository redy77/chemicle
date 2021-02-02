package com.chemcool.school.theory.service;


import com.chemcool.school.theory.domain.ChemistryLesson;
import com.chemcool.school.theory.domain.ChemistryLessonEvent;
import com.chemcool.school.theory.domain.ChemistryLessonEventType;
import com.chemcool.school.theory.storage.ChemistryLessonEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistryLessonEventService {

    private final KafkaTemplate<String, ChemistryLessonEvent> kafkaTemplate;
    private final ChemistryLessonEventJournal journal;

    private void kafkaSend(String topic, String msgId, ChemistryLessonEvent event) {
        ListenableFuture<SendResult<String, ChemistryLessonEvent>> future = kafkaTemplate.send(topic, msgId, event);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }

    public void save(ChemistryLesson task) {
        //todo написать реализацию
        ChemistryLessonEvent event = ChemistryLessonEvent.createEvent(task, ChemistryLessonEventType.CREATED);
        kafkaSend("lesson-theory", "1", event);
    }

    public void update(ChemistryLesson lesson) {
        //todo написать реализацию
        ChemistryLessonEvent event = ChemistryLessonEvent.createEvent(lesson, ChemistryLessonEventType.UPDATED);
        kafkaSend("lesson-theory", "1", event);
    }
}
