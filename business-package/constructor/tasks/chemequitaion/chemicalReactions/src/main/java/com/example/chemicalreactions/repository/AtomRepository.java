package com.example.chemicalreactions.repository;

import com.example.chemicalreactions.domein.Atom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AtomRepository extends JpaRepository<Atom, Integer> {

}