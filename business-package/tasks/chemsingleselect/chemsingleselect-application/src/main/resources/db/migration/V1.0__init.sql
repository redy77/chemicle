create table if not exists fixed_answer (
    chemistry_fixed_answer_task_uuid varchar(255) not null primary key,
    description    VARCHAR(5000),
    right_answer VARCHAR(255),
    chapter_id VARCHAR(255),
    type_of_task VARCHAR(255)
);


create table if not exists chemistry_equation_task
(
    chemistry_equation_task_uuid varchar(255) not null primary key,
    description    VARCHAR(255),
    right_products VARCHAR(255),
    chapter_id VARCHAR(255),
    type_of_task VARCHAR(255),
    reagents VARCHAR(255),
    wrong_products1 VARCHAR(255),
    wrong_products2 VARCHAR(255),
    wrong_products3 VARCHAR(255)
);

create table if not exists matching_task_of_two_sides
(
    chemistry_matching_task_uuid varchar(255) not null primary key,
    description    VARCHAR(255),
    chapter_id  VARCHAR(255),
    type_of_task VARCHAR(255)
    );

create table if not exists couples
(
    couple_for_matching_uuid varchar(255) not null primary key,
    left_couple varchar(255),
    right_couple varchar(255),
    question_id varchar(255),
    CONSTRAINT fkbhwrqjl4x1cwwlq48gjqau0c FOREIGN KEY (question_id)
    REFERENCES matching_task_of_two_sides (chemistry_matching_task_uuid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);

create table if not exists chemistry_single_select_task
(
    chemistry_single_select_task_uuid  varchar(255) not null primary key,
    description VARCHAR(5000),
    right_answer varchar(255),
    chapter_id  VARCHAR(255),
    type_of_task VARCHAR(255),
    incorrect_answer1 varchar(255),
    incorrect_answer2 varchar(255),
    incorrect_answer3 varchar(255)
);