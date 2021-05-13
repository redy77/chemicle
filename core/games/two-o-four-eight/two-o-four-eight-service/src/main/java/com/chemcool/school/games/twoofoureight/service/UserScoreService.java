package com.chemcool.school.games.twoofoureight.service;

import com.chemcool.school.games.twoofoureight.domain.UserScore;
import com.chemcool.school.games.twoofoureight.storage.UserScoreRepository;
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
        UserScore userScoreDB = userScoreRepository.findByUserId(userScore.getUserId());

        if (userScoreDB == null) {
            userScoreRepository.save(userScore);
        } else {
            userScoreDB.setScore(userScore.getScore());
            userScoreDB.setUserId(userScore.getUserId());
        }

    }

    public List<UserScore> getAllUsers() {
        return userScoreRepository.findAll();
    }
}
