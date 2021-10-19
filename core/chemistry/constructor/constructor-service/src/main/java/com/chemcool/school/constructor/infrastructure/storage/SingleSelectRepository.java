package com.chemcool.school.constructor.infrastructure.storage;

import com.chemcool.school.constructor.domain.SingleSelectTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleSelectRepository extends JpaRepository<SingleSelectTask, String> {

}
