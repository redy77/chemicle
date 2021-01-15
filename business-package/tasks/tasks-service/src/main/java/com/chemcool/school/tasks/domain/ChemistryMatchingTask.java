package com.chemcool.school.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matching_task_of_two_sides")
public class ChemistryMatchingTask {

    @Id
    @Column(name = "chemistry_matching_task_uuid")
    private String chemistryMatchingTaskUuid;

    @Column(name = "description")
    private String description;

    @Column(name = "chapter_id")
    private String chapterId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_task")
    private TypeOfTask typeOfTask;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<CoupleForMatching> coupleForMatchingList;

}
