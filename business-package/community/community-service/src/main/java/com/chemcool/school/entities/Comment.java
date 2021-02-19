package com.chemcool.school.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private String author;

    private String date;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="lesson_id", nullable=false)
    private Lesson lesson;

    public Comment(String comment, String author, String date, Lesson lesson) {
        this.comment = comment;
        this.author = author;
        this.date = date;
        this.lesson=lesson;
    }
}
