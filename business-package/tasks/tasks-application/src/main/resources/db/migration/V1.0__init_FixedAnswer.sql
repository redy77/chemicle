create table if not exists fixed_answer (
            id varchar(255) not null primary key,
            description varchar(5000),
            right_answer varchar(255) not null,
            chapter_id integer not null,
            type_of_task String not null
);