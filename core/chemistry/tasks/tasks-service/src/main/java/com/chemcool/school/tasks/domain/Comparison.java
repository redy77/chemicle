package com.chemcool.school.tasks.domain;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@DiscriminatorValue("COMPARISON")
public class Comparison extends AbstractTask {

    @Column
    @NonNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<ComparisonPair> comparisonPairs;
}
