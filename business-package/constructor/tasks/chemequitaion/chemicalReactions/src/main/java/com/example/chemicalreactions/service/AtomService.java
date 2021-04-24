package com.example.chemicalreactions.service;

import com.example.chemicalreactions.domein.Atom;
import com.example.chemicalreactions.repository.AtomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtomService {

    private final AtomRepository atomRepository;

    @Autowired
    public AtomService(AtomRepository himUrStrRepository) {
        this.atomRepository = himUrStrRepository;
    }

    public Atom findByIdAtom(Integer id){
        return atomRepository.getOne(id);
    }

    public List<Atom> findAllAtom(){
        return atomRepository.findAll();
    }

    public void saveAtom(Atom atom){
        atomRepository.save(atom);
    }

    public void deleteByIdAtom(Integer id){
        atomRepository.deleteById(id);
    }
}
