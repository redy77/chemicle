package com.chemcool.school.lesson.web.api.classForController;

import com.chemcool.school.lesson.web.api.service.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class LessonDtoList {
    private ChemEquationsTaskDtoList equationsTaskDtoList;
    private ChemFixedAnswerTaskDtoList chemFixedAnswerTaskDtoList;
    private ChemMatchingTaskDtoList chemMatchingTaskDtoList;
    private ChemSingleSelectTaskDtoList chemSingleSelectTaskDtoList;
    private ChemTheoryDtoList chemTheoryDtoList;

    @JsonIgnore
    private ChemEquationsTaskPresentation equationsTaskPresentation;
    @JsonIgnore
    private ChemFixedAnswerTaskPresentation fixedAnswerTaskPresentation;
    @JsonIgnore
    private ChemMatchingTaskPresentation matchingTaskPresentation;
    @JsonIgnore
    private ChemSingleSelectTaskPresentation singleSelectTaskPresentation;
    @JsonIgnore
    private ChemTheoryPresentation theoryPresentation;

    @Autowired
    public void setConfig(
            ChemEquationsTaskPresentation equationsTaskPresentation,
            ChemFixedAnswerTaskPresentation fixedAnswerTaskPresentation,
            ChemMatchingTaskPresentation matchingTaskPresentation,
            ChemSingleSelectTaskPresentation singleSelectTaskPresentation,
            ChemTheoryPresentation theoryPresentation) {
        this.equationsTaskPresentation = equationsTaskPresentation;
        this.fixedAnswerTaskPresentation = fixedAnswerTaskPresentation;
        this.matchingTaskPresentation = matchingTaskPresentation;
        this.singleSelectTaskPresentation = singleSelectTaskPresentation;
        this.theoryPresentation = theoryPresentation;
    }

    public LessonDtoList(ChemEquationsTaskDtoList equationsTaskDtoList,
                         ChemFixedAnswerTaskDtoList chemFixedAnswerTaskDtoList,
                         ChemMatchingTaskDtoList chemMatchingTaskDtoList,
                         ChemSingleSelectTaskDtoList chemSingleSelectTaskDtoList,
                         ChemTheoryDtoList chemTheoryDtoList) {
        this.equationsTaskDtoList = equationsTaskDtoList;
        this.chemFixedAnswerTaskDtoList = chemFixedAnswerTaskDtoList;
        this.chemMatchingTaskDtoList = chemMatchingTaskDtoList;
        this.chemSingleSelectTaskDtoList = chemSingleSelectTaskDtoList;
        this.chemTheoryDtoList = chemTheoryDtoList;
    }

    public LessonDtoList getLessonByReference(Integer referenceId) {
        return new LessonDtoList(
                ChemEquationsTaskDtoList.getTaskByReference(equationsTaskPresentation, referenceId),
                ChemFixedAnswerTaskDtoList.getTaskByReference(fixedAnswerTaskPresentation, referenceId),
                ChemMatchingTaskDtoList.getTaskByReference(matchingTaskPresentation, referenceId),
                ChemSingleSelectTaskDtoList.getTaskByReference(singleSelectTaskPresentation, referenceId),
                ChemTheoryDtoList.getTheoryByReference(theoryPresentation, referenceId)
        );
    }

    public LessonDtoList getLessonByChapter(Integer chapterId) {
        return new LessonDtoList(
                ChemEquationsTaskDtoList.getTaskByChapter(equationsTaskPresentation, chapterId),
                ChemFixedAnswerTaskDtoList.getTaskByChapter(fixedAnswerTaskPresentation, chapterId),
                ChemMatchingTaskDtoList.getTaskByChapter(matchingTaskPresentation, chapterId),
                ChemSingleSelectTaskDtoList.getTaskByChapter(singleSelectTaskPresentation, chapterId),
                ChemTheoryDtoList.getTheoryByChapter(theoryPresentation, chapterId)
        );
    }

    public LessonDtoList getLessonByReferenceAndChapter(Integer referenceId, Integer chapterId) {
        return new LessonDtoList(
                ChemEquationsTaskDtoList.getTaskByReferenceAndChapter(equationsTaskPresentation,
                referenceId, chapterId),
                ChemFixedAnswerTaskDtoList.getTaskByReferenceAndChapter(fixedAnswerTaskPresentation,
                        referenceId, chapterId),
                ChemMatchingTaskDtoList.getTaskByReferenceAndChapter(matchingTaskPresentation, referenceId, chapterId),
                ChemSingleSelectTaskDtoList.getTaskByReferenceAndChapter(singleSelectTaskPresentation,
                        referenceId, chapterId),
                ChemTheoryDtoList.getTaskByReferenceAndChapter(theoryPresentation, referenceId, chapterId)
        );
    }
}
