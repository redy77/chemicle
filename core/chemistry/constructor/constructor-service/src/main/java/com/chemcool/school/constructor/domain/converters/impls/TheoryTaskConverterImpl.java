package com.chemcool.school.constructor.domain.converters.impls;

import com.chemcool.school.constructor.domain.TheoryTask;
import com.chemcool.school.constructor.domain.converters.TheoryTaskConverter;
import com.chemcool.school.constructor.domain.representation.TheoryTaskRepresentation;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Service
public class TheoryTaskConverterImpl implements TheoryTaskConverter {

    public TheoryTask convertToTask(TheoryTaskRepresentation representation) {
        return TheoryTask.builder()
                .taskId(UUID.randomUUID().toString())
                .conditionOfTask(representation.getConditionOfTask())
                .classNum(representation.getClassNum())
                .chapterNum(representation.getChapterNum())
                .paragraphNum(representation.getParagraphNum())
                .status(TaskStatus.CREATE)
                .type(TaskType.THEORY)
                .isHidden(false)
                .theoryText(representation.getTheoryText())
                .build();
    }
}
