package com.example.chemicalreactions.controller.rest;

import com.example.chemicalreactions.domein.Molecule;
import com.example.chemicalreactions.service.MoleculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/molecules/rest")
public class MoleculeRestController {

//    private final MoleculeService moleculeService;
//
//    @Autowired
//    public MoleculeRestController(MoleculeService moleculeService) {
//        this.moleculeService = moleculeService;
//    }
//
//    @GetMapping("/all") //возвращает все молекулы в виде []  json
//    public List<Molecule> findAllMolecule(){
//        return moleculeService.findAllMolecule();
//    }
//
//    @GetMapping("/{id}") //возвращает конкретный атом в виде json
//    public Molecule oneMolecule(@PathVariable("id") String id) {
//        Molecule molecule1 = new Molecule();
//        List<Molecule> allMolecule = moleculeService.findAllMolecule();
//        for (Molecule molecule : allMolecule){
//            if (molecule.getNameMolecule().equals(id)){
//                return molecule;
//            }
//        }
//        return molecule1;
//    }
}
