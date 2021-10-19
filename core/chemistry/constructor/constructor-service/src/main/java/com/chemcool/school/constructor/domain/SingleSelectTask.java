package com.chemcool.school.constructor.domain;

import com.chemcool.school.tasks.models.Task;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class SingleSelectTask extends Task {

    @Column(name = "right_answer")
    private String rightAnswer;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> answers = new ArrayList<>();

}
