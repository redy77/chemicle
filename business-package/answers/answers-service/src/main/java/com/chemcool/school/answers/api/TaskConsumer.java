package com.chemcool.school.answers.api;

import com.chemcool.school.answers.service.ChemEquationCorrectAnswersService;
import com.chemcool.school.answers.service.ChemFixedCorrectAnswersService;
import com.chemcool.school.answers.service.ChemSingleSelectCorrectAnswersService;
import com.chemcool.school.answers.service.ChemmathesCorrectAnswersService;
import com.chemcool.school.answers.tasks.chemequation.domain.ChemEquationsTaskEvent;
import com.chemcool.school.answers.tasks.chemequation.service.ChemEquationsTaskEventService;
import com.chemcool.school.answers.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;
import com.chemcool.school.answers.tasks.chemfixedanswer.service.ChemFixedAnswerTaskEventService;
import com.chemcool.school.answers.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
import com.chemcool.school.answers.tasks.chemmatches.service.ChemistryMatchingTaskEventService;
import com.chemcool.school.answers.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import com.chemcool.school.answers.tasks.chemsingleselect.service.ChemSingleSelectTaskEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Service
@EnableKafka
@EnableTransactionManagement
@RequiredArgsConstructor
public class TaskConsumer {

    private final ChemFixedAnswerTaskEventService fixedAnswerTaskEventService;
    private final ChemistryMatchingTaskEventService matchingTaskEventService;
    private final ChemSingleSelectTaskEventService singleSelectTaskEventService;
    private final ChemEquationsTaskEventService equationsTaskEventService;

    private final ChemEquationCorrectAnswersService chemEquationCorrectAnswersService;
    private final ChemmathesCorrectAnswersService chemmathesCorrectAnswersService;
    private final ChemFixedCorrectAnswersService chemFixedCorrectAnswersService;
    private final ChemSingleSelectCorrectAnswersService chemSingleSelectCorrectAnswersService;


    @KafkaListener(topics = "fixed-answer", containerFactory = "chemFixedAnswerKafkaListenerContainerFactory")
    @KafkaHandler
    public void handleChemFixedAnswerTask(ConsumerRecord<String, ChemFixedAnswerTaskEvent> record) {
        ChemFixedAnswerTaskEvent event = record.value();
        log.info("Пойман журнал для логирования с ID: " + event.getEventId());
        fixedAnswerTaskEventService.handleEvent(event);
        chemFixedCorrectAnswersService.saveCorrectAnswers(event.getEventPayload());
    }

    @KafkaListener(topics = "tasks-matching", containerFactory = "matchingKafkaListenerContainerFactory")
    @KafkaHandler
    public void handleChemistryMatchingTask(ConsumerRecord<String, ChemistryMatchingTaskEvent> record) {
        ChemistryMatchingTaskEvent event = record.value();
        log.info("Пойман журнал для логирования: " + event.getChemistryMatchingTaskEventId());
        matchingTaskEventService.handleEvent(event);
        chemmathesCorrectAnswersService.saveCorrectAnswers(event.getChemistryMatchingTaskEventPayload());
    }

    @KafkaListener(topics = "tasks-single-select", containerFactory = "chemSingleSelectKafkaListenerContainerFactory")
    @KafkaHandler
    public void handleChemSingleSelectTask(ConsumerRecord<String, ChemSingleSelectTaskEvent> record) {
        ChemSingleSelectTaskEvent event = record.value();
        log.info("Пойман журнал для логирования: " + event.getTaskEventId());
        singleSelectTaskEventService.handleEvent(event);
        chemSingleSelectCorrectAnswersService.saveCorrectAnswers(event.getPayload());
    }

    @KafkaListener(topics = "equations-task", containerFactory = "chemeQuitationsKafkaListenerContainerFactory")
    @KafkaHandler
    public void handleChemEquationsTask(ConsumerRecord<String, ChemEquationsTaskEvent> record) {
        ChemEquationsTaskEvent event = record.value();
        log.info("Пойман журнал для логирования с ID: " + event.getEventId());
        equationsTaskEventService.handleEvent(event);
        chemEquationCorrectAnswersService.saveCorrectAnswer(event.getEventPayload());
    }
}
