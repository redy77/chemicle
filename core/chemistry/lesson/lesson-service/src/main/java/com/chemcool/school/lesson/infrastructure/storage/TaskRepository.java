package com.chemcool.school.lesson.infrastructure.storage;

import com.chemcool.school.tasks.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public interface TaskRepository extends JpaRepository<Task, String> {
}
