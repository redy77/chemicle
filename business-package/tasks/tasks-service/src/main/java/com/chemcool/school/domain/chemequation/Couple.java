package com.chemcool.school.domain.chemequation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "couples")
public class Couple {

    @Id
    private String id;

    //Вопрос
    private String coupleLeft;

    //Ответ
    private String coupleRight;

//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Question question;
}
