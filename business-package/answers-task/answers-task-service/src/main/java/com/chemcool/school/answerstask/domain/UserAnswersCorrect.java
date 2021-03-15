package com.chemcool.school.answerstask.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_answers_correct")
@Data
@NoArgsConstructor
public class UserAnswersCorrect {

    public UserAnswersCorrect(String userId, String userEmail, String correctAnswersTaskId) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.correctAnswersTaskId = correctAnswersTaskId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "correct_answer_task_id", unique = true)
    private String correctAnswersTaskId;
}
