create table if not exists chemistry_matching_task_event(
    chemistry_matching_task_event_id varchar(255) not null primary key,
    chemistry_matching_task_event_author_id varchar(255) not null,
    chemistry_matching_task_event_occurring_context varchar(255) not null,
    chemistry_matching_task_event_occurring_context_time timestamp not null,
    chemistry_matching_task_event_payload jsonb not null  #надо допилить на jsonb

);