DROP TABLE if exists users_linked_rooms;
DROP TABLE if exists messages;
DROP TABLE if exists users;
DROP TABLE if exists rooms;
DROP TYPE if exists message_type;
--
-- CREATE TABLE users (
--                        id VARCHAR(255) NOT NULL,
--                        name VARCHAR(255) NOT NULL,
--                        role VARCHAR(255) NOT NULL,
--                        PRIMARY KEY (id),
--                        UNIQUE (id)
-- );
--
-- CREATE TABLE rooms (
--                        id VARCHAR(255) NOT NULL,
--                        name VARCHAR(255) NOT NULL,
--                        PRIMARY KEY (id),
--                        UNIQUE (id)
-- );
-- CREATE TABLE users_linked_rooms (
--                                     id VARCHAR(255) NOT NULL,
--                                     room_id VARCHAR(255) NOT NULL,
--                                     user_id VARCHAR(255) NOT NULL,
--                                     PRIMARY KEY (id),
--                                     UNIQUE (id, room_id, user_id),
--                                     FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE,
--                                     FOREIGN KEY (room_id) REFERENCES rooms(id) ON UPDATE CASCADE
-- );
--
-- CREATE TYPE message_type AS ENUM('CHAT', 'JOIN', 'LEAVE');
--
-- CREATE TABLE messages (
--                           id VARCHAR(255) NOT NULL,
--                           room_id VARCHAR(255) NOT NULL,
--                           sender_id VARCHAR(255) NOT NULL,
--                           name VARCHAR(255) NOT NULL,
--                           message VARCHAR(2048) NOT NULL,
--                           published_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
--                           type message_type,
--                           PRIMARY KEY (id),
--                           UNIQUE (id),
--                           FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE
-- );


