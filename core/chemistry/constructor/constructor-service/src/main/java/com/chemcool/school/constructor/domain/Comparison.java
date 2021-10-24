package com.chemcool.school.constructor.domain;

import com.chemcool.school.tasks.models.Task;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "comparison")
@Builder
@RequiredArgsConstructor
public class Comparison extends Task {

    @Column
    @NonNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<ComparisonPair> comparisonPairs;
}
