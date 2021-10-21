package com.chemcool.school.constructor.storage;

import com.chemcool.school.constructor.domain.Comparison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComparisonRepository extends JpaRepository<Comparison, String> {
}
