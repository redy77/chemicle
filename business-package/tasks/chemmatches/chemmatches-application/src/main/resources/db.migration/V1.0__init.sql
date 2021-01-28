create table if not exists chemistry_matching_task_event(
    chemistry_matching_task_event_id                     varchar(255) not null primary key,
    chemistry_matching_task_event_author_id              varchar(255) not null,
    chemistry_matching_task_event_entity_id              varchar(255) not null,
    chemistry_matching_task_event_occurring_context      varchar(255) not null,
    chemistry_matching_task_event_occurring_context_time timestamp not null,
    chemistry_matching_task_event_payload                jsonb not null,
    chemistry_matching_task_event_type                   integer not null,
    version                                              varchar(255) not null
);

create table if not exists chemistry_matching_task(
    chemistry_matching_task_uuid varchar(255) not null primary key,
    chapter_id                   varchar(255) not null,
    description                  varchar(10000) not null,
    type_of_task                 varchar(255) not null
);

create table if not exists couples_for_matching(
    couple_for_matching_uuid varchar(255) not null primary key,
    left_couple              varchar(255) not null,
    right_couple             varchar(255) not null,
    question_id              varchar(255) not null
        constraint fka8s958flt0ucxdnfde8hkmquq
            references chemistry_matching_task
);