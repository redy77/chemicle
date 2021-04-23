package com.example.chemicalreactions.controller;

import com.example.chemicalreactions.domein.Molecule;
import com.example.chemicalreactions.service.MoleculeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/molecules")
public class MoleculeController {

    private final MoleculeService moleculeService;

    public MoleculeController(MoleculeService moleculeService) {
        this.moleculeService = moleculeService;
    }

    @GetMapping("/all") //HTML страница с таблицей всех атомов
    public String findAll(Principal principal, Model model){
        List<Molecule> molecules = moleculeService.findAllMolecule();
        model.addAttribute("molecules", molecules);
        return "moleculesAll";
    }
}
