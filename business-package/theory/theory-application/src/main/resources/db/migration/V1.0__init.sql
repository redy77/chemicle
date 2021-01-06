create table if not exists chemistry_lesson_page (
            lesson_id varchar(255) not null primary key,
            lesson_name varchar(255) not null,
            lesson_description varchar(5000),
            lesson_chapter  varchar(10) not null,
            lesson_references varchar(10) not null

);