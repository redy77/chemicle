package com.chemcool.school.tasks.domain.converters;

import com.chemcool.school.tasks.domain.Comparison;
import com.chemcool.school.tasks.domain.ComparisonPair;
import com.chemcool.school.tasks.domain.representation.ComparisonPresentation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        Comparison comparison = Comparison
                .builder()
                .comparisonPairs(comparisonPairs)
                .build();

        comparison.setConditionOfTask(comparisonPresentation.getConditionOfTask());
        comparison.setClassNum(comparisonPresentation.getClassNum());
        comparison.setChapterNum(comparisonPresentation.getChapterNum());
        comparison.setParagraphNum(comparisonPresentation.getParagraphNum());

        return comparison;
    }
}
