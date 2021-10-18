package com.chemcool.school.constructor.domain.сomparison;

import com.chemcool.school.tasks.models.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "comparison")
public class Comparison extends Task {

    /*@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "task_id")
    private String taskId;*/

    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<ComparisonPair> items;
}
