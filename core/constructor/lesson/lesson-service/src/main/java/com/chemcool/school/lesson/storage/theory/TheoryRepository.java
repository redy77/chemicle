package com.chemcool.school.lesson.storage.theory;


import com.chemcool.school.lesson.domain.theory.ChemTheory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TheoryRepository extends JpaRepository<ChemTheory, UUID>, JpaSpecificationExecutor<ChemTheory> {


    String tableName = "chemistry_page";

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE " + tableName + " SET " +
                    " theory_chapter = :theoryChapter, " +
                    " theory_name = :theoryName, " +
                    " theory_description = :theoryDescription, " +
                    " theory_references = :theoryReferences " +
                    " WHERE theory_id = :theoryId",
            nativeQuery = true
    )
    void updateTheory(
            @Param("theoryId") String theoryId,
            @Param("theoryName") String theoryName,
            @Param("theoryChapter") Integer theoryChapter,
            @Param("theoryDescription") String theoryDescription,
            @Param("theoryReferences") Integer theoryReferences
    );

    Optional<ChemTheory> getAllByTheoryId(String theoryId);

    List<ChemTheory> getAllByTheoryChapter(Integer theoryChapter);

    List<ChemTheory> getAllByTheoryReferences(Integer theoryReferences);

    List<ChemTheory> getAllByTheoryReferencesAndTheoryChapter(Integer theoryReferences, Integer theoryChapter);


}
