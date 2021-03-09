package com.chemcool.school.lesson.theory.service;


import com.chemcool.school.lesson.domain.ChemistryLesson;
import com.chemcool.school.lesson.theory.domain.ChemistryTheory;
import com.chemcool.school.lesson.theory.storage.TheoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistryTheoryPageService {

    private final TheoryRepository repository;


    public String save(ChemistryTheory theory) {
        repository.save(theory);
        log.info("Сохранил теорию c UUID" + theory.getTheoryId());
        return theory.getTheoryId();
    }

    public void delete(ChemistryTheory theory) {
        log.info("Удалена теория = " + theory);
        repository.delete(theory);
    }

    public void update(ChemistryTheory chemistry) {
        log.info("Обновлена задача с UUID = " + chemistry.getTheoryId() );
        repository.save(chemistry);
    }

    public ChemistryTheory findTheoryById(String theoryId) {
        //  TODO проверить на то, что lessonId не пустой.
        if (theoryId == null || theoryId.isEmpty()) {
            throw new RuntimeException("theoryId параметр пустой, проверьте конфигурацию.");
        }
        return repository.findByTheoryId(theoryId);
    }


    public ChemistryLesson findTaskAndTheoryByChapter(int chapter){
        return null;
     //   return pageService.findTaskAndTheoryByChapter(chapter);
    }


    public ChemistryLesson findTaskAndTheoryByReferences(int references){
        return null;
   //     return pageService.findTaskAndTheoryByReferences(references);
    }
}
