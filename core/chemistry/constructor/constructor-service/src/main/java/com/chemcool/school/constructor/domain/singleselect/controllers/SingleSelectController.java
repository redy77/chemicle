package com.chemcool.school.constructor.domain.singleselect.controllers;

import com.chemcool.school.constructor.domain.singleselect.entities.SingleSelectCon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/single_select")
public class SingleSelectController {

    @PostMapping()
    public ResponseEntity<SingleSelectCon> addUser(@RequestBody SingleSelectCon singleSelectCon) {
         return ResponseEntity.ok(singleSelectCon); //дописать метод
    }

}
