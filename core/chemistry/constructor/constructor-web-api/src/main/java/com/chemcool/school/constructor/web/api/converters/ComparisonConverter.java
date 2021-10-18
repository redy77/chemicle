package com.chemcool.school.constructor.web.api.converters;

import com.chemcool.school.constructor.domain.сomparison.Comparison;
import com.chemcool.school.constructor.domain.сomparison.ComparisonPair;
import com.chemcool.school.constructor.domain.сomparison.ComparisonStatement;
import com.chemcool.school.constructor.web.api.dto.ComparisonDto;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ComparisonConverter {

    public Comparison convertDtoToEntity(ComparisonDto comparisonDto) {
        Comparison comparison = new Comparison();

        List<String> keys = comparisonDto.getKeys();
        List<String> values = comparisonDto.getValues();
        HashMap<String, String> mapping = comparisonDto.getMapping();
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
        comparison.setConditionOfTask(comparisonDto.getConditionOfTask());
        comparison.setClassNum(comparisonDto.getClassNum());
        comparison.setChapterNum(comparisonDto.getChapterNum());
        comparison.setParagraphNum(comparisonDto.getParagraphNum());
        comparison.setTaskType(TaskType.COMPARISON);
        comparison.setTaskStatus(TaskStatus.CREATE);
        comparison.setIsHidden(false);

        return comparison;
    }
}
