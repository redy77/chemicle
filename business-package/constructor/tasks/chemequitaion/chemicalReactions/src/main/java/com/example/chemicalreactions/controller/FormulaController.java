package com.example.chemicalreactions.controller;

import com.example.chemicalreactions.domein.Atom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/formula")
public class FormulaController {

    @GetMapping("/string") //HTML страница с таблицей всех атомов
    public String findAll(){
        return "formula";
    }

    @GetMapping("/string2") //HTML страница с таблицей всех атомов
    public String findAll2(){
        return "formul_variant_vtoroy";
    }
}
