package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.domain.Comparison;
import com.chemcool.school.tasks.domain.FixedAnswerTask;
import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.web.api.dto.ComparisonDto;
import com.chemcool.school.tasks.web.api.dto.FixedAnswerDto;
import com.chemcool.school.tasks.web.api.dto.SingleSelectDto;

import java.util.List;

/**
 * @Author : Constantine Lee
 * @Date : 27.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public interface TaskToDtoConverter {

    SingleSelectDto singleSelectDto(SingleSelectTask task);

    ComparisonDto comparisonDto(Comparison task);

    FixedAnswerDto fixedAnswerDto(FixedAnswerTask task);
}
