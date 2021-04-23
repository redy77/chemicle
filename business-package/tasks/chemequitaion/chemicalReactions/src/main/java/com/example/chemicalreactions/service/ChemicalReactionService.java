package com.example.chemicalreactions.service;

import com.example.chemicalreactions.domein.ChemicalReaction;
import com.example.chemicalreactions.repository.ChemicalReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChemicalReactionService {

    private final ChemicalReactionRepository chemicalReactionRepository;

    @Autowired
    public ChemicalReactionService(ChemicalReactionRepository chemicalReactionRepository) {
        this.chemicalReactionRepository = chemicalReactionRepository;
    }


    public ChemicalReaction findByIdChemicalReaction(Integer id){
        return chemicalReactionRepository.getOne(id);
    }

    public List<ChemicalReaction> findAllChemicalReaction(){
        return chemicalReactionRepository.findAll();
    }

    public void saveChemicalReaction(ChemicalReaction chemicalReaction){
        chemicalReactionRepository.save(chemicalReaction);
    }

    public void deleteByIdChemicalReaction(Integer id){
        chemicalReactionRepository.deleteById(id);
    }
}
