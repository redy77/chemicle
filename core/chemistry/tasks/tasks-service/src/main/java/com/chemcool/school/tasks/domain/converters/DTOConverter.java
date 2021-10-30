package com.chemcool.school.tasks.domain.converters;

public interface DTOConverter<Task, DTO> {

    DTO taskToDto(Task task);

    Task dtoToTask(DTO dto);

}
