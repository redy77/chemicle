package com.chemcool.school.tasks.domain.chemcomparison;

import com.chemcool.school.tasks.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComparisonTask extends Task {

    private String rightAnswer;
    private Set<String> leftValuesArray;
    private Set<String> rightValuesArray;

}
