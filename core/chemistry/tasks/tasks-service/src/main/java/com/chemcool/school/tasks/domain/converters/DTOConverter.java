package com.chemcool.school.tasks.domain.converters;

/**
 * @Author : Constantine Lee
 * @Date : 27.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public interface DTOConverter<Task, DTO> {

    DTO taskToDto(Task task);

    Task dtoToTask(DTO dto);

}
