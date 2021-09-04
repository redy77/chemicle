package com.chemcool.school.constructor.domain.singleselect.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "single_select_table")
public class SingleSelectCon {
    @Id
    private Long id;
    private String conditionOfTask;
    private String rightAnswer;
    private String answersArray;
    private int classNum;
    private int chapterNum;
    private int paragraphNum;
    private String taskStatus;
    private boolean isHiden;

}
