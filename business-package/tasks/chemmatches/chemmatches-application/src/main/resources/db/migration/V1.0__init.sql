create table if not exists chemistry_matching_task_event(
    chemistry_matching_task_event_id                     varchar(255) not null primary key,
    chemistry_matching_task_event_author_id              varchar(255) not null,
    chemistry_matching_task_event_entity_id              varchar(255) not null,
    chemistry_matching_task_event_occurring_context      varchar(255) not null,
    chemistry_matching_task_event_occurring_context_time timestamp not null,
    chemistry_matching_task_event_payload                jsonb not null,
    chemistry_matching_task_event_type                   varchar(255) null,
    version                                              varchar(255) not null
);

create table if not exists chemistry_matching_task(
    task_id                      varchar(255) not null primary key,
    chapter_id                   integer not null,
    reference_id                 integer not null,
    description                  varchar(10000) not null
);

create table if not exists couples_for_matching(
    couple_id                bigint not null primary key,
    left_couple              varchar(255) not null,
    right_couple             varchar(255) not null,
    task_id                  varchar(255) not null
    constraint               fkqrg9epawfu7v3uju9daokxa08
            references chemistry_matching_task
);
