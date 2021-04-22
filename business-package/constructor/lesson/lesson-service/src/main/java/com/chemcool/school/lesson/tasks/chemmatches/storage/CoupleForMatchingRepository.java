package com.chemcool.school.lesson.tasks.chemmatches.storage;

import com.chemcool.school.lesson.tasks.chemmatches.domain.CoupleForMatching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleForMatchingRepository extends JpaRepository<CoupleForMatching, String> {
}