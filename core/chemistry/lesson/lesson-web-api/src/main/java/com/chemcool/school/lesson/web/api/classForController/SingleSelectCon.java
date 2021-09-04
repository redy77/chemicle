package com.chemcool.school.lesson.web.api.classForController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Single_Select_Con")
public class SingleSelectCon {
    @Id
    @Column(name = "id", unique = true)
    private long id;
    @Column(name = "conditionOfTask")
    private String conditionOfTask;
    @Column(name = "rightAnswer")
    private String rightAnswer;
    @Column(name = "answersArray")
    private String answersArray;
    @Column(name = "classNum")
    private String classNum;
    @Column(name = "chapterNum")
    private String chapterNum;
    @Column(name = "paragraphNum")
    private String paragraphNum;
    @Column(name = "taskStatus")
    private String taskStatus;
    @Column(name = "isHiden")
    private String isHiden;

}
