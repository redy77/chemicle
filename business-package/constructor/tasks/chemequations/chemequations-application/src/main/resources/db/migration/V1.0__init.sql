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
);
