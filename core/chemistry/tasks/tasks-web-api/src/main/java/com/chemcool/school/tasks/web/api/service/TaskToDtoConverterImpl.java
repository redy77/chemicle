package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.domain.Comparison;
import com.chemcool.school.tasks.domain.FixedAnswerTask;
import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.web.api.dto.ComparisonDto;
import com.chemcool.school.tasks.web.api.dto.FixedAnswerDto;
import com.chemcool.school.tasks.web.api.dto.SingleSelectDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Constantine Lee
 * @Date : 27.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Service
public class TaskToDtoConverterImpl implements TaskToDtoConverter {
    @Override
    public SingleSelectDto singleSelectDto(SingleSelectTask task) {
        return SingleSelectDto.builder()
                .taskId(task.getTaskId())
                .conditionOfTask(task.getConditionOfTask())
                .classNum(task.getClassNum())
                .chapterNum(task.getChapterNum())
                .paragraphNum(task.getParagraphNum())
                .rightAnswer(task.getRightAnswer())
                .answers(task.getAnswers())
                .build();
    }

    @Override
    public ComparisonDto comparisonDto(Comparison task) {
        return null; //todo
    }

    @Override
    public FixedAnswerDto fixedAnswerDto(FixedAnswerTask task) {
        return FixedAnswerDto.builder()
                .taskId(task.getTaskId())
                .conditionOfTask(task.getConditionOfTask())
                .classNum(task.getClassNum())
                .chapterNum(task.getChapterNum())
                .paragraphNum(task.getParagraphNum())
                .answer(task.getAnswer())
                .build();
    }
}
