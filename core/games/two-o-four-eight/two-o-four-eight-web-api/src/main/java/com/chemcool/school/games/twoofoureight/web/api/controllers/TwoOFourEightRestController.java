package com.chemcool.school.games.twoofoureight.web.api.controllers;

import com.chemcool.school.games.twoofoureight.domain.UserScore;
import com.chemcool.school.games.twoofoureight.service.UserScoreService;
import com.chemcool.school.games.twoofoureight.web.api.jwt.JWTParser;
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
    private final String DBUserID = "100";
    private final String DBUserEmail = null;

    @GetMapping("/valid")
    @ResponseBody
    public String isValid(@RequestHeader(value = "Authorization") String token) {
        String userID = jwtParser.getIdUserOfToken(token);
        String userEmail = jwtParser.getEmailUserOfToken(token);
        if (userID.equals(DBUserID) && userEmail == DBUserEmail) {
            return Boolean.TRUE.toString();
        }
        return Boolean.FALSE.toString();
    }

    @PostMapping("/save")
    public String save(@RequestHeader(value = "Authorization") String token,
                       @RequestBody(required = false) Map<String, String> payload) {
        UserScore userScore = new UserScore();
        userScore.setUserId(jwtParser.getIdUserOfToken(token));
        userScore.setScore((String)payload.get("myScore"));
        userScoreService.saveUserScore(userScore);
        return userScore.toString();
    }

    @GetMapping("/getAll")
    public List<UserScore> getAllUserScoreData(){
        return userScoreService.getAllUsers();
    }
}
