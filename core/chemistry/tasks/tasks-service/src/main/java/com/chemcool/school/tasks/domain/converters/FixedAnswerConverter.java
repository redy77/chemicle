package com.chemcool.school.tasks.domain.converters;

import com.chemcool.school.tasks.domain.FixedAnswerTask;
import com.chemcool.school.tasks.domain.dto.FixedAnswerDTO;
import org.springframework.stereotype.Component;

/**
 * @Author : Constantine Lee
 * @Date : 30.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Component("fixedAnswer")
public class FixedAnswerConverter implements DTOConverter<FixedAnswerTask, FixedAnswerDTO> {

    @Override
    public FixedAnswerDTO taskToDto(FixedAnswerTask fixedAnswerTask) {
        return null;
    }

    @Override
    public FixedAnswerTask dtoToTask(FixedAnswerDTO fixedAnswerDTO) {
        return null;
    }
}
