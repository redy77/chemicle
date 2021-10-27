package com.chemcool.school.tasks.domain;
/**
 * @Author Constantine Lee
 */

import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@DiscriminatorValue("SINGLE_SELECT")
public class SingleSelectTask extends AbstractTask {

    @Column(name = "correct_answer")
    private String rightAnswer;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> answers = new ArrayList<>();
}
