package com.chemcool.school.theory.domain;

import com.chemcool.school.tasks.models.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TheoryTask extends Task {

    @Column(name = "theory_text")
    private String theoryText;
}
