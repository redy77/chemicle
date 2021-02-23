create table if not exists users
(
    id       varchar(255) not null
        constraint users_pkey
            primary key,
    city     varchar(255),
    email    varchar(255)
        constraint uk_user_email
            unique,
    name     varchar(255),
    nick     varchar(255),
    password varchar(255),
    phone    varchar(255),
    role     varchar(255),
    surname  varchar(255),
    type     varchar(255)
);

create table if not exists users_event
(
    event_id               varchar(255) not null
        constraint users_event_pkey
            primary key,
    author_id              varchar(255),
    entity_id              varchar(255),
    event_type             varchar(255),
    event_version          varchar(255),
    occurring_context      varchar(255),
    occurring_context_time timestamp,
    payload                jsonb
);