package com.chemcool.school.constructor.service.сomparison;

import com.chemcool.school.constructor.domain.сomparison.Comparison;
import com.chemcool.school.constructor.domain.сomparison.ComparisonPair;
import com.chemcool.school.constructor.domain.сomparison.ComparisonStatement;
import com.chemcool.school.constructor.presentation.ComparisonPresentation;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ComparisonConverter {

    public Comparison convertPresentationToEntity(ComparisonPresentation comparisonPresentation) {
        Comparison comparison = new Comparison();

        List<String> keys = comparisonPresentation.getKeys();
        List<String> values = comparisonPresentation.getValues();
        HashMap<String, String> mapping = comparisonPresentation.getMapping();
        List<ComparisonPair> items = new ArrayList<>();

        mapping.forEach((key, value) -> {
            int keyIndex = keys.indexOf(key);
            int valueIndex = values.indexOf(value);

            if (keyIndex == -1 || valueIndex == -1) {
                //TODO Customize exception
                throw new RuntimeException("Invalid request");
            }

            ComparisonStatement keyStatement = new ComparisonStatement(key, keyIndex);
            ComparisonStatement valueStatement = new ComparisonStatement(value, valueIndex);

            ComparisonPair comparisonPair = new ComparisonPair();
            comparisonPair.setKey(keyStatement);
            comparisonPair.setValue(valueStatement);

            items.add(comparisonPair);
        });

        //TODO fix auto-generating id
        comparison.setTaskId("task-id");
        comparison.setItems(items);
        comparison.setConditionOfTask(comparisonPresentation.getConditionOfTask());
        comparison.setClassNum(comparisonPresentation.getClassNum());
        comparison.setChapterNum(comparisonPresentation.getChapterNum());
        comparison.setParagraphNum(comparisonPresentation.getParagraphNum());
        comparison.setTaskType(TaskType.COMPARISON);
        comparison.setTaskStatus(TaskStatus.CREATE);
        comparison.setIsHidden(false);

        return comparison;
    }
}
