package com.chemcool.school.tasks.chemequations.web.api.controllers;

import com.chemcool.school.tasks.chemequations.domain.ChemCompound;
import com.chemcool.school.tasks.chemequations.domain.ChemElement;
import com.chemcool.school.tasks.chemequations.service.ChemElementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Тестовый контроллер для проверки функционала
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@RestController
public class ChemEquationsRestControllerTest {

    private final ChemElementService elementService;
    private ArrayList<ChemElement> elements;


    public ChemEquationsRestControllerTest(ChemElementService elementService) {
        this.elementService = elementService;
        this.elements = new ArrayList<>();
    }


    @GetMapping("/get")
    public String getSummary(int elementNumber) {
        ChemCompound chemCompound = new ChemCompound();
        elements.add(elementService.getByNumber(elementNumber).orElseThrow());
        chemCompound.reaction(elements);
        return chemCompound.getCompoundSymbols();
    }

    @GetMapping("/clean")
    public void clean() {
        elements.clear();
    }
}
