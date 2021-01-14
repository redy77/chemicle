package com.chemcool.school.theory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "chemistry_lesson_page")
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryLesson {

    @Id
    private String lessonId;

    @Column(name = "lesson_name")
    @NonNull
    private String lessonName;

    @Column(
            name = "lesson_descprtion",
            length = 10000
    )
    private String lessonDescription;

    @NonNull
    @Column(name = "lesson_chapter")
    private Integer lessonChapter;

    @NonNull

    @Column(name = "lesson_references")
    private Integer lessonReferences;


    public static ChemistryLesson createChemistryLesson(
            ChemistryLessonExample example
    ) {
        return new ChemistryLesson(
                UUID.randomUUID().toString(),
                example.getLessonExampleName(),
                example.getLessonExampleDescription(),
                example.getLessonExampleChapter(),
                example.getLessonExampleReferences()
        );
    }

}