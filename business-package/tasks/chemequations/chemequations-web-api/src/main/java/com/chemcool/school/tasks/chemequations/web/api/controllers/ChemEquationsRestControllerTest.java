package com.chemcool.school.tasks.chemequations.web.api.controllers;

import com.chemcool.school.tasks.chemequations.domain.ChemCompound;
import com.chemcool.school.tasks.chemequations.service.ChemElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChemEquationsRestControllerTest {

    private final ChemElementService service;

    @GetMapping("/get")
    public String getSummary() {
        ChemCompound chemCompound = new ChemCompound();
        chemCompound.reaction(
                service.getById("1").orElseThrow(),
                service.getById("1").orElseThrow(),
                service.getById("1").orElseThrow(),
                service.getById("3").orElseThrow(),
                service.getById("3").orElseThrow(),
                service.getById("3").orElseThrow(),
                service.getById("10").orElseThrow(),
                service.getById("10").orElseThrow(),
                service.getById("10").orElseThrow(),
                service.getById("2").orElseThrow(),
                service.getById("2").orElseThrow(),
                service.getById("28").orElseThrow());
        System.out.println(chemCompound.getCompoundSymbols());
        return chemCompound.getCompoundSymbols();
    }

    @PostMapping("/post")
    public String post(String firstElementId, String secondElementId){
        ChemCompound chemCompound = new ChemCompound();
        chemCompound.reaction(
                service.getById(firstElementId).orElseThrow(),
                service.getById(secondElementId).orElseThrow()
        );
        return chemCompound.getCompoundSymbols();
    }


}
