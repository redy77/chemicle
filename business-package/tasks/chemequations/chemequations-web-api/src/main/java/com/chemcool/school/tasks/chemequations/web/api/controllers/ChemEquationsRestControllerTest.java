package com.chemcool.school.tasks.chemequations.web.api.controllers;

import com.chemcool.school.tasks.chemequations.domain.Elements.ChemCompound;
import com.chemcool.school.tasks.chemequations.domain.Elements.ChemElement;
import com.chemcool.school.tasks.chemequations.service.ChemElementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Тестовый контроллер для проверки функционала
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@Slf4j
@RestController
public class ChemEquationsRestControllerTest {

    private final ChemElementService elementService;
    private ArrayList<ChemElement> elements;


    public ChemEquationsRestControllerTest(ChemElementService elementService) {
        this.elementService = elementService;
        this.elements = new ArrayList<>();
    }


    @GetMapping("/get")
    public String getSummary(String elementNumber) {
        ChemCompound chemCompound = new ChemCompound();
        String[] elementsMass = elementNumber.split(",");

        Arrays.stream(elementsMass).forEach(e -> elements.add(elementService.getByNumber(Integer.valueOf(e)).orElseThrow()));
//        elements.add(elementService.getByNumber(elementNumber).orElseThrow());
        chemCompound.reaction(elements);
//        log.info("grope: " + elementService.getByNumber(elementNumber).orElseThrow().getElementGroup());
//        log.info("val: " + elementService.getByNumber(elementNumber).orElseThrow().getElementValence());
        System.out.println();
        return chemCompound.getCompoundSymbols();
    }

    @GetMapping("/clean")
    public void clean() {
        elements.clear();
    }
}
