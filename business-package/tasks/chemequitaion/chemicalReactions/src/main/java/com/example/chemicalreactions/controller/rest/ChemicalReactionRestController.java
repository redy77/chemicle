package com.example.chemicalreactions.controller.rest;

import com.example.chemicalreactions.domein.ChemicalReaction;
import com.example.chemicalreactions.service.ChemicalReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chemical_reaction")
public class ChemicalReactionRestController {

    private final ChemicalReactionService chemicalReactionService;

    @Autowired
    public ChemicalReactionRestController(ChemicalReactionService chemicalReactionService) {
        this.chemicalReactionService = chemicalReactionService;
    }

    @GetMapping("/all") //возвращает все молекулы в виде []  json
    public List<ChemicalReaction> findAllChemicalReaction(){
        return chemicalReactionService.findAllChemicalReaction();
    }

    @GetMapping("/{id}") //возвращает конкретный атом в виде json
    public ChemicalReaction oneChemicalReaction(@PathVariable("id") String id) {
        ChemicalReaction chemicalReaction1 = new ChemicalReaction();
        List<ChemicalReaction> allChemicalReaction = chemicalReactionService.findAllChemicalReaction();
        for (ChemicalReaction chemicalReaction : allChemicalReaction){
            if (chemicalReaction.getStringChemicalReaction().equals(id)){
                return chemicalReaction;
            }
        }
        return chemicalReaction1;
    }
}
