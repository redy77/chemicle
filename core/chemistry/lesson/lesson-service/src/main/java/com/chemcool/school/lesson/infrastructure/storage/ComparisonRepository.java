package com.chemcool.school.lesson.infrastructure.storage;

import com.chemcool.school.lesson.domain.Comparison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Constantine Lee
 * @Date : 25.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Repository
public interface ComparisonRepository extends JpaRepository<Comparison, String> {
}
