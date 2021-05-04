package com.chemcool.school.tasks.chemmatches.infrastructure.storage;

import com.chemcool.school.tasks.chemmatches.domain.CoupleForMatching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleForMatchingRepository extends JpaRepository<CoupleForMatching, String> {
}