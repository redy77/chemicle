package com.chemcool.school.tasks.domain.representations;

/**
 * @Author : Constantine Lee
 * @Date : 29.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public interface TaskRepresentation {
    String getTaskId();
    String getConditionOfTask();
    Short getClassNum();
    Short getChapterNum();
    Short getParagraphNum();
}
