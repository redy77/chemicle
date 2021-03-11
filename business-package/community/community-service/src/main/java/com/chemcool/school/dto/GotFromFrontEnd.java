package com.chemcool.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GotFromFrontEnd implements Serializable {
    private String comment;
    private String author;
    private String date;
    private Long lessonId;


}
