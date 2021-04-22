package com.example.chemicalreactions.controller.rest;

import com.example.chemicalreactions.domein.Atom;
import com.example.chemicalreactions.service.AtomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atoms/rest")
public class AtomRestController {

    private final AtomService atomService;

    @Autowired
    public AtomRestController(AtomService atomService) {
        this.atomService = atomService;
    }

    @GetMapping("/all") //предоставляет данные всех атомов в виде массива json
    public List<Atom> findAll(){
        return atomService.findAllAtom();
    }

    @GetMapping("/{id}") //возвращает конкретный атом в виде json
    public Atom oneAtom(@PathVariable("id") String id) {
        Atom atom1 = new Atom();
        List<Atom> allAtom = atomService.findAllAtom();
        for (Atom atom : allAtom){
            if (atom.getSymbol().equals(id)){
                return atom;
            }
        }
        return atom1;
    }
}
