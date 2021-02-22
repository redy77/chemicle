package com.chemcool.school.tasks.chemequations.service;

import com.chemcool.school.tasks.chemequations.domain.ChemBaseCompound;
import com.chemcool.school.tasks.chemequations.domain.ChemElement;
import com.chemcool.school.tasks.chemequations.storage.ChemBaseCompoundRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemBaseCompoundService {
    private final ChemBaseCompoundRepository baseCompoundRepository;

    public String save(ChemBaseCompound baseCompound){
        baseCompoundRepository.save(baseCompound);
        log.info("Базовое соединение с ID: " + baseCompound.getBaseCompoundId() + "  добавлено.");
        return baseCompound.getBaseCompoundId();
    }

    public List<ChemBaseCompound> getAll (){
        return baseCompoundRepository.findAll();
    }

    public Optional<ChemBaseCompound> getById (String id){
        return baseCompoundRepository.findById(id);
    }
}
