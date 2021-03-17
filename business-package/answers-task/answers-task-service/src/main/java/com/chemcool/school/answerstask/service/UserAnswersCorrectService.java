package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.domain.UserAnswersCorrect;
import com.chemcool.school.answerstask.storage.UserAnswersCorrectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAnswersCorrectService {
    private final UserAnswersCorrectRepository userAnswersCorrectRepository;

    public void saveUserCorrectAnswers(UserAnswersCorrect userAnswersCorrect) {
        userAnswersCorrectRepository.save(userAnswersCorrect);
    }

    public List<String> getAllUserResolvedTaskId(String userId) {
        List<String> userResolvedTaskId = new ArrayList<>();
        List<UserAnswersCorrect> allUserResolvedTaskId = userAnswersCorrectRepository.getAllUserResolvedTaskId(userId);
        for (UserAnswersCorrect iter : allUserResolvedTaskId) {
            userResolvedTaskId.add(iter.getCorrectAnswersTaskId());
        }
        return userResolvedTaskId;
    }
}
