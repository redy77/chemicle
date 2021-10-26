package com.chemcool.school.tasks.infrastructure.storage;

import com.chemcool.school.tasks.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
