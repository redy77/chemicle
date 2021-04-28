package com.chemcool.school.braingames.twoofoureight.web.api.controllers;

import com.chemcool.school.braingames.twoofoureight.web.api.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/valid")
@RequiredArgsConstructor
public class TwoOFourEightRestController {

    private final JWTParser jwtParser;
    //    @Value("authentication.db")
    private String DBUserID = "100";
    //    @Value("authentication.db")
    private String DBUserEmail = null;

    @GetMapping()
    @ResponseBody
    public String isValid(@RequestHeader(value = "AuthorizationToken") String token) {
        String userID = jwtParser.getIdUserOfToken(token);
        String userEmail = jwtParser.getEmailUserOfToken(token);
        if (userID == DBUserID && userEmail == DBUserEmail) { //узнать как вытаскивать юзеров
            return Boolean.TRUE.toString();
        }
        return Boolean.FALSE.toString();
    }


/** на сегодня вижу так: нужно:
 получаем токен
 парсим его - получаем данные
 сравниваем данные с базой текущих юзеров
 если есть совпадение возвращаем тру иначе фолс
 */

}
