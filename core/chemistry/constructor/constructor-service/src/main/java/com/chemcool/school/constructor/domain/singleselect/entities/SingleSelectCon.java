package com.chemcool.school.constructor.domain.singleselect.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
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
    @Column(name = "condition_of_task")
    private String conditionOfTask;
    @Column(name = "right_answer")
    private String rightAnswer;
    @Column(name = "answer_array")
    private String answersArray;
    @Column(name = "class_num")
    @NonNull
    private int classNum;
    @Column(name = "chapter_num")
    @NonNull
    private int chapterNum;
    @Column(name = "paragraph_num")
    @NonNull
    private int paragraphNum;
    @Column(name = "task_status")
    private String taskStatus;
    @Column(name = "is_hiden")
    private boolean isHiden;

}
