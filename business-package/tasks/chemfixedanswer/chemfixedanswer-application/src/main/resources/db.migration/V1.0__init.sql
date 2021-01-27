create table if not exists chemistry_fixed_answer_task (
    chemistry_fixed_answer_task_uuid varchar(255) not null primary key,
    description VARCHAR(5000),
    right_answer VARCHAR(255),
    chapter_id VARCHAR(255),
    type_of_task VARCHAR(255)
);

create table if not exists chemistry_fixed_answer_tast_event (
    chem_fixed_answer_task_event_uuid VARCHAR(255) not null primary,
    chem_fixed_answer_task_event_author_id VARCHAR(255) not null,
    chem_fixed_answer_task_event_occuring_comtext VARCHAR(255) not null,
    chem_fixed_answer_task_event_occuring_context_time TIMESTAMP not null,
    chem_fixed_answer_task_event_type VARCHAR(255) not null,
    chem_fixed_answer_task_event_version VARCHAR(255),
    chem_fixed_answer_task_event_entity_id VARCHAR(255),
    chem_fixed_answer_task_event_payload jsonb not null
);