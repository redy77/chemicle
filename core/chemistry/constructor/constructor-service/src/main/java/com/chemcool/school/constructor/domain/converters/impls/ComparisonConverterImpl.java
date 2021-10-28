package com.chemcool.school.constructor.domain.converters.impls;

import com.chemcool.school.constructor.domain.Comparison;
import com.chemcool.school.constructor.domain.ComparisonPair;
import com.chemcool.school.constructor.domain.converters.ComparisonConverter;
import com.chemcool.school.constructor.domain.representation.ComparisonPresentation;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Component
public class ComparisonConverterImpl implements ComparisonConverter {

    public Comparison convertPresentationToEntity(ComparisonPresentation comparisonPresentation) {
        HashMap<String, String> correctAnswers = comparisonPresentation.getCorrectAnswers();
        List<ComparisonPair> comparisonPairs = new ArrayList<>();

        correctAnswers.forEach((leftValue, rightValue) -> {
            ComparisonPair comparisonPair = new ComparisonPair();

            comparisonPair.setLeftValue(leftValue);
            comparisonPair.setRightValue(rightValue);

            comparisonPairs.add(comparisonPair);
        });

        return Comparison.builder()
                .taskId(UUID.randomUUID().toString())
                .conditionOfTask(comparisonPresentation.getConditionOfTask())
                .classNum(comparisonPresentation.getClassNum())
                .chapterNum(comparisonPresentation.getChapterNum())
                .paragraphNum(comparisonPresentation.getParagraphNum())
                .status(TaskStatus.CREATE)
                .type(TaskType.COMPARISON)
                .isHidden(false)
                .comparisonPairs(comparisonPairs)
                .build();
    }
}
