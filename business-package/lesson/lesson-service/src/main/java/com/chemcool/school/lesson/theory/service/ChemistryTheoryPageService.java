package com.chemcool.school.lesson.theory.service;


import com.chemcool.school.lesson.theory.domain.ChemTheory;
import com.chemcool.school.lesson.theory.storage.TheoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistryTheoryPageService {

    private final TheoryRepository repository;


    public String save(ChemTheory theory) {
        repository.save(theory);
        log.info("Сохранил теорию c UUID" + theory.getTheoryId());
        return theory.getTheoryId();
    }

    public void delete(ChemTheory theory) {
        log.info("Удалена теория = " + theory);
        repository.delete(theory);
    }

    public void update(ChemTheory chemistry) {
        log.info("Обновлена задача с UUID = " + chemistry.getTheoryId() );
        repository.save(chemistry);
    }

    public ChemTheory getAllByTheoryId(String theoryId) {
        //  TODO проверить на то, что lessonId не пустой.
        if (theoryId == null || theoryId.isEmpty()) {
            throw new RuntimeException("theoryId параметр пустой, проверьте конфигурацию.");
        }
        return repository.getAllByTheoryId(theoryId);
    }

    public List<ChemTheory> getAll() {
        //  TODO проверить на то, что lessonId не пустой.

        return repository.findAll();
    }


    public List<ChemTheory> getAllByChapterId(int chapter){
        if (chapter == 0 ) {
            throw new RuntimeException("chapter параметр пустой, проверьте конфигурацию.");
        }
        return repository.getAllByTheoryChapter(chapter);
    }

    public List<ChemTheory> getAllByReferenceId(int referenceId){
        if (referenceId == 0 ) {
            throw new RuntimeException("chapter параметр пустой, проверьте конфигурацию.");
        }
        return repository.getAllByTheoryReferences(referenceId);
    }
}
