package com.example.chemicalreactions.service;

import com.example.chemicalreactions.domein.Molecule;
import com.example.chemicalreactions.repository.MoleculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoleculeService {

    private final MoleculeRepository moleculeRepository;

    @Autowired
    public MoleculeService(MoleculeRepository moleculeRepository) {
        this.moleculeRepository = moleculeRepository;
    }

    public Molecule findByIdMolecule(String id){
        return moleculeRepository.getOne(id);
    }

    public List<Molecule> findAllMolecule(){
        return moleculeRepository.findAll();
    }

    public void saveMolecule(Molecule molecule){
        moleculeRepository.save(molecule);
    }

    public void deleteByIdMolecule(String id){
        moleculeRepository.deleteById(id);
    }
}
