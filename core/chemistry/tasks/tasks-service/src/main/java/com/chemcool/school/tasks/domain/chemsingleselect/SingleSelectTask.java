package com.chemcool.school.tasks.domain.chemsingleselect;

import com.chemcool.school.tasks.models.Task;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SingleSelectTask extends Task {
    private String rightAnswer;
    private String answersArray;
}
