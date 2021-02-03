create table if not exists chemistry_single_select_task
(
    id                     varchar(255) not null
        constraint chemistry_single_select_task_pkey
        primary key,
    chapter_id             integer,
    correct_answer         varchar(255),
    description            varchar(10000),
    incorrect_answer_one   varchar(255),
    incorrect_answer_two   varchar(255),
    incorrect_answer_three varchar(255),
    incorrect_answer_four  varchar(255),
    reference_id           integer
);

create table chemistry_single_select_task_event
(
    id                    varchar(255) not null
        constraint chemistry_single_select_task_event_pkey
        primary key,
    author_id             varchar(255),
    entity_id             varchar(255),
    event_type            integer,
    event_version         varchar(255),
    occuring_comtext      varchar(255),
    occuring_context_time timestamp,
    payload               jsonb
);
