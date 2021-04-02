create table if not exists article_task_event (
    event_id varchar(255) not null primary key,
    event_author_id varchar(255),
    event_occurring_context varchar (255),
    event_occurring_context_time timestamp,
    event_type int4,
    event_version varchar(255),
    event_entity_id varchar(255),
    event_payload jsonb
    );

create table if not exists articles (
    article_id varchar(255) not null primary key,
    article_title varchar(300) not null,
    article_body varchar(10000),
    article_author  varchar(50)
    );
