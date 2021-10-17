package com.chemcool.school.constructor.domain.сomparison;

import com.chemcool.school.tasks.models.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Comparison extends Task {

    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskId")
    private List<ComparisonPair> items;
}
