create table if not exists fixed_answer (
    chemistry_fixed_answer_task_uuid varchar(255) not null primary key,
    description    VARCHAR(5000),
    right_answer VARCHAR(255),
    chapter_id VARCHAR(255),
    type_of_task VARCHAR(255)
);