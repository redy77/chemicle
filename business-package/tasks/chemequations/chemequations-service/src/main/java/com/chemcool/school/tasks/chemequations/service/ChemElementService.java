package com.chemcool.school.tasks.chemequations.service;

import com.chemcool.school.tasks.chemequations.domain.ChemElement;
import com.chemcool.school.tasks.chemequations.storage.ChemElementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemElementService {
    private final ChemElementRepository elementRepository;

    public String save(ChemElement element){
        elementRepository.save(element);
        log.info("Элемент с ID: " + element.getElementId() + "  добавлен.");
        return element.getElementId();
    }

    public List<ChemElement> getAll (){
        return elementRepository.findAll();
    }

    public Optional<ChemElement> getById (String id){
        return elementRepository.findById(id);
    }
}
