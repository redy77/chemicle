package com.chemcool.school.repo;

import com.chemcool.school.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LessonRepo extends JpaRepository<Lesson,Long> {
}
