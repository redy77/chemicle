-- Drop tables

DROP TABLE if exists fixed_answer;
DROP TABLE if exists choise_of_answer;
DROP TABLE if exists matching_task_of_two_sides;
DROP TABLE if exists couples;
DROP TABLE if exists chemistry_equation_task;




-- Table: fixedAnswer
CREATE TABLE fixedAnswer
(
    fixedAnswer_uuid   VARCHAR(255)  PRIMARY KEY,
    description    CHAR(5000) NOT NULL,
    right_answer VARCHAR(255) NOT NULL,
    chapter_id VARCHAR(255) NOT NULL,
    type_of_tasks VARCHAR(255)
)

-- Table: choise_of_answer
CREATE TABLE choise_of_answer
(
    choise_of_answer_uuid   VARCHAR(255) PRIMARY KEY,
    description    CHAR NOT NULL,
    mark INT ,-- Сложность в баллах числом
    right_answer VARCHAR(255) ,
    incorrectAnswer1 VARCHAR(255),
    incorrectAnswer2 VARCHAR(255),
    incorrectAnswer3 VARCHAR(255),
    chapter VARCHAR(255) NOT NULL

)

-- Table: matching
CREATE TABLE matching_task_of_two_sides
(
    matching_task_of_two_sides_uuid   VARCHAR(255)  PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    chapter_id VARCHAR(255) NOT NULL,
    question    VARCHAR(255) NOT NULL,
)

CREATE TABLE couples
(
    couples_uuid VARCHAR(255)  PRIMARY KEY,
    left_couple VARCHAR(255) NOT NULL,
    rightCouple VARCHAR(255) NOT NULL
)

-- Table: chemistry_equation_task
CREATE TABLE chemistry_equation_task
(
    chemistry_equation_task_uuid   VARCHAR(255)  PRIMARY KEY,
    description    VARCHAR(255) NOT NULL,
    right_products    VARCHAR(255) NOT NULL,
    chapter_id  VARCHAR(255) NOT NULL,
    type_of_tasks VARCHAR(255)NOT NULL,
    reagents VARCHAR(255)NOT NULL,
    wrong_products_1 VARCHAR(255)NOT NULL,
    wrong_products_2 VARCHAR(255)NOT NULL,
    wrong_products_3 VARCHAR(255)NOT NULL
)

