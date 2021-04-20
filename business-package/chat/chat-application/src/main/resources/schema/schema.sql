DROP TABLE if exists users_linked_rooms;
DROP TABLE if exists messages;
DROP TABLE if exists users;
DROP TABLE if exists rooms;
DROP TYPE if exists message_type;

CREATE TABLE users (
                       id VARCHAR(25) NOT NULL,
                       name VARCHAR(25) NOT NULL,
                       role VARCHAR(25) NOT NULL,
                       PRIMARY KEY (id),
                       UNIQUE (id)
);

CREATE TABLE rooms (
                       id VARCHAR(25) NOT NULL,
                       name VARCHAR(25) NOT NULL,
                       PRIMARY KEY (id),
                       UNIQUE (id)
);
CREATE TABLE users_linked_rooms (
                                    id VARCHAR(25) NOT NULL,
                                    room_id VARCHAR(25) NOT NULL,
                                    user_id VARCHAR(25) NOT NULL,
                                    PRIMARY KEY (id),
                                    UNIQUE (id, room_id, user_id),
                                    FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE,
                                    FOREIGN KEY (room_id) REFERENCES rooms(id) ON UPDATE CASCADE
);

CREATE TYPE message_type AS ENUM('CHAT', 'JOIN', 'LEAVE');

CREATE TABLE messages (
                          id VARCHAR(255) NOT NULL,
                          room_id VARCHAR(255) NOT NULL,
                          sender_id VARCHAR(255) NOT NULL,
                          sender_name VARCHAR(255) NOT NULL,
                          message VARCHAR(255) NOT NULL,
                          published_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
--                           type VARCHAR(8),
                          type message_type,
                          PRIMARY KEY (id),
                          UNIQUE (id),
                          FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE
);


