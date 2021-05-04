<<<<<<< HEAD
create table chemistry_element (
    element_id varchar(255) not null,
    element_transcription varchar(255),
    element_group int4,
    element_lat_name varchar(255),
    element_molar_mass float8,
    element_name varchar(255),
    element_number int4,
    element_oxidation_value varchar(255),
    element_period varchar(255),
    element_subgroup varchar(255),
    element_symbol varchar(255),
    element_valence varchar(255),
    primary key (element_id)
);

create table chemistry_equations (
    task_id varchar(255) not null,
    chapter_id int4,
    description varchar(10000),
    reference_id int4,
    right_answer varchar(255),
    primary key (task_id)
);

create table chemistry_equations_event (
    event_id varchar(255) not null,
    event_author_id varchar(255),
    event_entity_id varchar(255),
    event_occuring_comtext varchar(255),
    event_occuring_context_time timestamp,
    event_payload jsonb,
    event_type int4,
    event_version varchar(255),
    primary key (event_id)
=======
GRANT all ON chemistry_fixed_answer_task TO mick;

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
    event_occuring_context VARCHAR(255) not null,
    event_occuring_context_time TIMESTAMP not null,
    event_type VARCHAR(255) not null,
    event_version VARCHAR(255),
    event_entity_id VARCHAR(255),
    event_payload jsonb not null
>>>>>>> origin/dmitrii(crud)
);
