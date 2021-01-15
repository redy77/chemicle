create table if not exists fixed_answer (
    fixed_answer_uuid varchar(255) not null primary key,
    description    CHAR(5000) NOT NULL,
    right_answer VARCHAR(255) NOT NULL,
    chapter_id VARCHAR(255) NOT NULL,
    type_of_tasks VARCHAR(255) NOT NULL
);


create table if not exists chemistry_equation_task
(
    chemistry_equation_task_uuid varchar(255) not null primary key,
    description    CHAR NOT NULL,
    right_products VARCHAR(255) NOT NULL,
    chapter_id VARCHAR(255) NOT NULL,
    type_of_tasks VARCHAR(255) NOT NULL,
    reagents VARCHAR(255) NOT NULL,
    wrong_products1 VARCHAR(255),
    wrong_products2 VARCHAR(255),
    wrong_products3 VARCHAR(255)
);


create table if not exists COMPARISON
(
    COMPARISON_id   varchar(255) not null primary key,
    description    VARCHAR(255) NOT NULL
);


create table if not exists matching_task_of_two_sides
(
    matching_task_of_two_sides_id   varchar(255) not null primary key,
    description    VARCHAR(255) NOT NULL,
    chapter_id  VARCHAR(255) NOT NULL,
    type_of_tasks VARCHAR(255)
);
