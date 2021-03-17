create table if not exists message
(
    id int8                 not null,
    filename                varchar(255),
    tag                     varchar(255),
    text                    varchar(255),
    author_id int8,
    primary key (id)
    );

create table if not exists user_role
(
    user_id int8            not null,
    roles                   varchar(255)
    );

create table if not exists usr
(
    id int8                 not null,
    active boolean          not null,
    password                varchar(255),
    username                varchar(255),
    primary key             (id)
    );

alter table if exists message
    add constraint message_user_fk
    foreign key (author_id) references usr;

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;

insert into usr (id, active, password, username)
values (1, 'admin', '1', true);

insert into user_role (user_id, roles)
values (1, 'ROLE_USER'), (1, 'ROLE_ADMIN');