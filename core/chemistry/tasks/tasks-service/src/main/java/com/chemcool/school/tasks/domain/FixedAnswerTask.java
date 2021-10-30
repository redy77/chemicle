package com.chemcool.school.tasks.domain;

import lombok.*;
import javax.persistence.*;


@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@DiscriminatorValue("FIXED_ANSWER")
public class FixedAnswerTask extends AbstractTask {

    @NonNull
    @Column(name = "correct_answer")
    private String answer;
}
