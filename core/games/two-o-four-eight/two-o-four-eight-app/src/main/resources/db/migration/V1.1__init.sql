create table if not exists users_auth
(
    id                   varchar(255) not null primary key,
    name                 varchar(255),
    role                 varchar(255)
);