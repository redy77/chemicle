package com.chemcool.school.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Collate {

    @Id
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question questionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    private Answer answerId;

//    @OneToMany(mappedBy="chapterId")
//    private Set<Chapter> chapterSet;
}
