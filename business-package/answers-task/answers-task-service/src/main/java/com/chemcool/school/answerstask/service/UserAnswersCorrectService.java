package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.domain.UserAnswersCorrect;
import com.chemcool.school.answerstask.storage.UserAnswersCorrectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAnswersCorrectService {
    private final UserAnswersCorrectRepository userAnswersCorrectRepository;

    public void saveUserCorrectAnswers(UserAnswersCorrect userAnswersCorrect) {
        userAnswersCorrectRepository.save(userAnswersCorrect);
    }
}
