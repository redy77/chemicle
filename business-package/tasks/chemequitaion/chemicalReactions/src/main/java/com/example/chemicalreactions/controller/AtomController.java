package com.example.chemicalreactions.controller;

import com.example.chemicalreactions.domein.Atom;
import com.example.chemicalreactions.service.AtomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/atoms")
public class AtomController {

    private final AtomService atomService;

    public AtomController(AtomService atomService) {
        this.atomService = atomService;
    }


    @GetMapping("/all") //HTML страница с таблицей всех атомов
    public String findAll(Principal principal, Model model){
        List<Atom> atoms = atomService.findAllAtom();
        model.addAttribute("atoms", atoms);
        return "atomsall";
    }
}
