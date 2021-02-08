create table if not exists chemistry_fixed_answer_task (
    task_id varchar(255) not null primary key,
    description VARCHAR(10000),
    right_answer VARCHAR(255),
    chapter_id int,
    reference_id int
);

create table if not exists chemistry_fixed_answer_task_event (
    event_uuid VARCHAR(255) not null primary key,
    event_author_id VARCHAR(255) not null,
    event_occuring_comtext VARCHAR(255) not null,
    event_occuring_context_time TIMESTAMP not null,
    event_type VARCHAR(255) not null,
    event_version VARCHAR(255),
    event_entity_id VARCHAR(255),
    event_payload jsonb not null
);