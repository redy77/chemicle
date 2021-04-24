create type message_type AS ENUM ('CHAT', 'JOIN', 'LEAVE');

create table messages
(
    id             varchar(255) not null,
    message        varchar(2048),
    room_id        varchar(255),
    name           varchar(255),
    published_date timestamp,
    type           message_type,
    sender_id      varchar(255),
    primary key (id)
);
create table rooms
(
    id   varchar(255) not null,
    name varchar(255),
    primary key (id)
);
create table users
(
    id   varchar(255) not null,
    name varchar(255),
    role varchar(255),
    primary key (id)
);
create table users_linked_rooms
(
    room_id varchar(255) not null,
    user_id varchar(255) not null
);
alter table if exists messages
    add constraint messages_sender_fk foreign key (sender_id) references users;
alter table if exists users_linked_rooms
    add constraint users_linked_rooms_user_fk foreign key (user_id) references users;
alter table if exists users_linked_rooms
    add constraint users_linked_rooms_room_fk foreign key (room_id) references rooms;