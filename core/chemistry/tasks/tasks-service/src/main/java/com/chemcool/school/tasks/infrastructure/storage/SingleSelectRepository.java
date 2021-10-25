package com.chemcool.school.tasks.infrastructure.storage;

import com.chemcool.school.tasks.domain.SingleSelectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Constantine Lee
 * @Date : 25.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Repository
public interface SingleSelectRepository extends JpaRepository<SingleSelectTask, String> {

}
