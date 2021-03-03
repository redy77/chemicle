create table if not exists users_registration_event
(
    user_registration_event_id                     varchar(255) not null primary key,
    user_registration_event_author_id              varchar(255) not null,
    user_registration_event_entity_id              varchar(255) not null,
    user_registration_event_version                VARCHAR(255) not null,
    user_registration_event_occurring_context      varchar(255) not null,
    user_registration_event_occurring_context_time timestamp    not null,
    user_registration_event_payload                jsonb        not null,
    user_registration_event_type                   varchar(255) not null,
);

create table if not exists users_registration
(
    user_id           varchar(255) not null primary key,
    user_email        varchar(255) not null,
    user_nick_name    varchar(255) not null,
    user_password     VARCHAR(255) not null,
    user_name         varchar(255) not null,
    user_surname      varchar(255) not null,
    user_role         varchar(255) not null,
    user_city         varchar(255) not null,
    user_phone_number varchar(255) not null,
    user_account_type varchar(255) not null
);
