package com.chemcool.school.constructor.domain.converters.impls;

import com.chemcool.school.constructor.domain.SingleSelectTask;
import com.chemcool.school.constructor.domain.converters.SingleSelectConverter;
import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SingleSelectConverterImpl implements SingleSelectConverter {

    public SingleSelectTask convertToTask(SingleSelectRepresentation representation) {
        return SingleSelectTask.builder()
                .taskId(UUID.randomUUID().toString())
                .conditionOfTask(representation.getConditionOfTask())
                .classNum(representation.getClassNum())
                .chapterNum(representation.getChapterNum())
                .paragraphNum(representation.getParagraphNum())
                .status(TaskStatus.CREATE)
                .type(TaskType.SINGLE_SELECT)
                .isHidden(false)
                .rightAnswer(representation.getRightAnswer())
                .answers(representation.getAnswers())
                .build();
    }
}
