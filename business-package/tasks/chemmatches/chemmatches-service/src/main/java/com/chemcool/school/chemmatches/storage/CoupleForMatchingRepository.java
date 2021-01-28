package com.chemcool.school.chemmatches.storage;

import com.chemcool.school.chemmatches.domain.CoupleForMatching;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupleForMatchingRepository extends JpaRepository<CoupleForMatching, String> {
}