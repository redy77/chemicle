package com.chemcool.school.constructor.domain;

import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;

import java.util.List;
import java.util.UUID;

public class SingleSelectPresentation {
    private String conditionOfTask;
    private String rightAnswer;
    private List<String> answers;
    private Short classNum;
    private Short chapterNum;
    private Short paragraphNum;

    public SingleSelectTask convertToTask() {
        SingleSelectTask task = new SingleSelectTask();
        task.setTaskId(UUID.randomUUID().toString());
        task.setConditionOfTask(this.conditionOfTask);
        task.setClassNum(this.classNum);
        task.setChapterNum(this.chapterNum);
        task.setParagraphNum(this.paragraphNum);
        task.setTaskStatus(TaskStatus.CREATE);
        task.setTaskType(TaskType.SINGLE_SELECT);
        task.setIsHidden(false);

        task.setRightAnswer(this.rightAnswer);
        task.setAnswers(this.answers);
        return task;
    }
}
