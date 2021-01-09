package com.chemcool.school.domain.chemequation;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "questions")
public class Question {

    @Id
    private String id;

    @Column(name = "question")
    private String question;

//    @ManyToOne
//    @JoinColumn(name = "chapter_id")
//    private Chapter chapter;
}
