package com.chemcool.school.domain.tasks.storage;

import com.chemcool.school.domain.tasks.domain.Couple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupleRepository extends JpaRepository<Couple, String> {
}
