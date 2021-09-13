package com.chemcool.school.tasks.domain.chemfixedanswer;

import com.chemcool.school.tasks.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixedAnswerTask extends Task {
    private String rightAnswer;
}
