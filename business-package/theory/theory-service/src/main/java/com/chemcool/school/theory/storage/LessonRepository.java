package com.chemcool.school.theory.storage;

import com.chemcool.school.theory.domain.ChemistryLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface LessonRepository extends JpaRepository<ChemistryLesson, UUID>, JpaSpecificationExecutor<ChemistryLesson> {

    String tableName = "chemistry_lesson_page";

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE " + tableName + " SET " +
                    " lesson_chapter = :lessonChapter, " +
                    " lesson_name = :lessonName, " +
                    " lesson_description = :lessonDescription, " +
                    " lesson_references = :lessonReferences " +
                    " WHERE lesson_id = :lessonId",
            nativeQuery = true
    )
    void updateLesson(
            @Param("lessonId") String lessonId,
            @Param("lessonName") String lessonName,
            @Param("lessonChapter") int lessonChapter,
            @Param("lessonDescription") String lessonDescription,
            @Param("lessonReferences") int lessonReferences
    );

}
