package com.chemcool.school.tasks.infrastructure.chemmatches.storage;

import com.chemcool.school.tasks.domain.chemmatches.CoupleForMatching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleForMatchingRepository extends JpaRepository<CoupleForMatching, String> {
}