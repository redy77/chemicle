package com.chemcool.school.constructor.infrastructure.storage;

import com.chemcool.school.constructor.domain.TheoryTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Repository
public interface TheoryTaskRepository extends JpaRepository<TheoryTask, String> {
}
