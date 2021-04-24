package com.example.chemicalreactions.repository;

import com.example.chemicalreactions.domein.Molecule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoleculeRepository extends JpaRepository<Molecule, String> {

}