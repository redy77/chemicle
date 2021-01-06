package com.chemcool.school.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "chemistry_lesson_page")
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryLessonPage {

    @Id
    private String lessonId;

    @Column(name = "lesson_name")
    private String lessonName;
    @Column(name = "lesson_descprtion")
    private String lessonDescription;
    @Column(name = "lesson_chapter")
    private String lessonChapter;
    @Column(name = "lesson_references")
    private String lessonReferences;




}
