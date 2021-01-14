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
public class MatchingOfTwoSidesTask {

    @Id
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "chapter_id")
    private String chapterId;

    @Column(name = "type_of_task")
    private TypeOfTask typeOfTask;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<CoupleForMatching> coupleForMatchings;

}
