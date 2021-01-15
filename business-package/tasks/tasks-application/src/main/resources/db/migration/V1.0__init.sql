-- Drop tables
DROP TABLE if exists fixed_answer;
DROP TABLE if exists chemistry_equation_task;
DROP TABLE if exists COMPARISON;
DROP TABLE if exists MATCHING_TASK_OF_TWO_SIDES;


CREATE TABLE fixed_answer
(
    id   VARCHAR(255)  PRIMARY KEY,
    description    CHAR(5000) NOT NULL,
    right_answer VARCHAR(255) NOT NULL,
    chapter_id VARCHAR(255) NOT NULL,
    type_of_tasks VARCHAR(255) NOT NULL,
)


CREATE TABLE chemistry_equation_task
(
    id   VARCHAR(255) PRIMARY KEY,
    description    CHAR NOT NULL,
    right_products VARCHAR(255) NOT NULL,
    chapter_id VARCHAR(255) NOT NULL,
    type_of_tasks VARCHAR(255) NOT NULL,
    reagents VARCHAR(255) NOT NULL,
    wrong_products1 VARCHAR(255),
    wrong_products2 VARCHAR(255),
    wrong_products3 VARCHAR(255)


)


CREATE TABLE COMPARISON
(
    id   VARCHAR(255)  PRIMARY KEY,
    description    VARCHAR(255) NOT NULL,
)


CREATE TABLE matching_task_of_two_sides
(
    id   VARCHAR(255)  PRIMARY KEY,
    description    VARCHAR(255) NOT NULL,
    chapter_id  VARCHAR(255) NOT NULL,
    type_of_tasks VARCHAR(255)
)
