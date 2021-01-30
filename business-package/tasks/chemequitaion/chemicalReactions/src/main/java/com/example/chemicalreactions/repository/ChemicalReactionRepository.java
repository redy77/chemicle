package com.example.chemicalreactions.repository;

import com.example.chemicalreactions.domein.ChemicalReaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemicalReactionRepository extends JpaRepository<ChemicalReaction, Integer> {

}