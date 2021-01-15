-- Drop tables
DROP TABLE if exists theory;
DROP TABLE if exists fixed_answer;
DROP TABLE if exists choise_of_answer;
DROP TABLE if exists matching;
DROP TABLE if exists chemistry_equation_task;


-- Table: theory
CREATE TABLE theory
(
    id       VARCHAR(255) NOT NULL,
    name_of_theme    VARCHAR(255) NOT NULL,
    description    CHAR NOT NULL,
    number_of_chapter INT NOT NULL,
    number_of_inset INT NOT NULL
)


-- Table: fixedAnswer
CREATE TABLE fixedAnswer
(
    id   VARCHAR(255)  PRIMARY KEY,
    description    CHAR NOT NULL,
    right_answer INT NOT NULL,
    number_of_chapter INT NOT NULL,
    type_of_tasks VARCHAR(255)
)

-- Table: choise_of_answer
CREATE TABLE choise_of_answer
(
    id   VARCHAR(255) PRIMARY KEY,
    description    CHAR NOT NULL,
    mark INT ,-- Сложность в баллах числом
    right_answer VARCHAR(255) ,
    incorrectAnswer1 VARCHAR(255),
    incorrectAnswer2 VARCHAR(255),
    incorrectAnswer3 VARCHAR(255),
    chapter VARCHAR(255) NOT NULL

)

-- Table: matching
CREATE TABLE matching
(
    id   VARCHAR(255)  PRIMARY KEY,
    question    VARCHAR(255) NOT NULL,
)

-- Table: chemistry_equation_task
CREATE TABLE chemistry_equation_task
(
    uuid   VARCHAR(255)  PRIMARY KEY,
    description    VARCHAR(255) NOT NULL,
    right_products    VARCHAR(255) NOT NULL,
    number_of_chapter INT NOT NULL,
    type_of_tasks VARCHAR(255)
)
