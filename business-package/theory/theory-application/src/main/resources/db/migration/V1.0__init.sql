create table if not exists chemistry_lesson_event (
            event_id varchar(255) not null primary key,
            event_author varchar(255) not null,
            event_occurring_context varchar (255) not null ,
            event_occurring_context_time timestamp not null,
            event_payload jsonb not null
);

create table if not exists chemistry_lesson_page (
            lesson_id varchar(255) not null primary key,
            lesson_name varchar(255) not null,
            lesson_description varchar(10000),
            lesson_chapter  integer not null,
            lesson_references integer not null

);