package com.chemcool.school.games.twoofoureight.web.api.controllers;

import com.chemcool.school.games.twoofoureight.domain.UserScore;
import com.chemcool.school.games.twoofoureight.service.UserScoreService;
import com.chemcool.school.games.twoofoureight.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class TwoOFourEightRestController {

    private final JWTParser jwtParser;
    private final UserScoreService userScoreService;

    @PostMapping("/save")
    public String save(@RequestHeader(value = "Authorization") String token,
                       @RequestBody(required = false) Map<String, String> payload) {
        UserScore userScore = new UserScore();
        userScore.setUserId(jwtParser.getUserIdFromToken(token));
        userScore.setScore(payload.get("myScore"));
        userScoreService.saveUserScore(userScore);
        return userScore.toString();
    }

    @GetMapping("/getAll")
    public List<UserScore> getAllUserScoreData(){
        return userScoreService.getAllUsers();
    }
}
