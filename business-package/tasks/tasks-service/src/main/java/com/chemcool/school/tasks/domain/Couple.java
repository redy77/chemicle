package com.chemcool.school.tasks.domain;

import com.chemcool.school.domain.chemequation.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "couples")
public class Couple {

    @Id
    private String id;

    private String coupleLeft;

    private String coupleRight;

}
