package com.chemcool.school.theory.storage;

import com.chemcool.school.theory.domain.ChemistryLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LessonRepository extends JpaRepository<ChemistryLesson, UUID>, JpaSpecificationExecutor<ChemistryLesson> {

}
