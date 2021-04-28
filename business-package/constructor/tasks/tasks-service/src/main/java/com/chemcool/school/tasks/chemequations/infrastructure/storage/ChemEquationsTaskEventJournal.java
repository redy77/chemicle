package com.chemcool.school.tasks.chemequations.infrastructure.storage;

import com.chemcool.school.tasks.chemequations.domain.ChemEquationsTaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Репозиторий для событий
 *
 * @version 1.0
 * @autor Евгений Жиленков
 */
public interface ChemEquationsTaskEventJournal
        extends JpaRepository<ChemEquationsTaskEvent, String> {
}
