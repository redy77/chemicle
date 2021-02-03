//package com.chemcool.school.chemmatches.service;
//
//import com.chemcool.school.chemmatches.domain.ChemistryMatchingTask;
//import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskEvent;
//import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskEventType;
//import com.chemcool.school.chemmatches.storage.ChemistryMatchingTaskEventJournal;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Service;
//import org.springframework.util.concurrent.ListenableFuture;
//
//@Service
//@RequiredArgsConstructor
//public class ChemistryMatchingTaskEventService {
//
//    private final KafkaTemplate<String, ChemistryMatchingTaskEvent> kafkaTemplate;
//    private final ChemistryMatchingTaskEventJournal journal;
//
//    private void kafkaSend(String topic, String msgId, ChemistryMatchingTaskEvent event) {
//        ListenableFuture<SendResult<String, ChemistryMatchingTaskEvent>> future = kafkaTemplate.send(topic, msgId, event);
//        future.addCallback(System.out::println, System.out::println);
//        kafkaTemplate.flush();
//    }
//
//    public void save(ChemistryMatchingTask task) {
//        //todo написать реализацию
//        ChemistryMatchingTaskEvent event = ChemistryMatchingTaskEvent.createEvent(task, ChemistryMatchingTaskEventType.CREATED);
//        kafkaSend("matching-task", "1", event);
//    }
//
//    public void update(ChemistryMatchingTask task) {
//        //todo написать реализацию
//        ChemistryMatchingTaskEvent event = ChemistryMatchingTaskEvent.createEvent(task, ChemistryMatchingTaskEventType.UPDATED);
//        kafkaSend("matching-task", "1", event);
//    }
//}
