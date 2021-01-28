package com.chemcool.school.chemmatches.domain;

import com.chemcool.school.chemmatches.TypeOfTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryMatchingTaskExample {
    private String chemistryMatchingTaskUuid;
    private String description;
    private String chapterId;
    private TypeOfTask typeOfTask;
    private List<CoupleForMatching> coupleForMatchingList;
}
