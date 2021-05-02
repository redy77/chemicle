package com.chemcool.school.braingames.twoofoureight.service;

import com.chemcool.school.braingames.twoofoureight.domain.UserScore;
import com.chemcool.school.braingames.twoofoureight.storage.UserScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserScoreService {
    private final UserScoreRepository userScoreRepository;

    public void saveUserScore(UserScore userScore) {
        userScoreRepository.save(userScore);
    }

    public List<UserScore> getAllUser() {
        return userScoreRepository.findAll();
    }
}
