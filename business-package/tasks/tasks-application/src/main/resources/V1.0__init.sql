-- Drop tables
DROP TABLE if exists theory;
DROP TABLE if exists fixed_answer;
DROP TABLE if exists choise_of_answer;
DROP TABLE if exists couples;

-- Table: theory
CREATE TABLE theory
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
    id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    shortName VARCHAR(255) ,
    description    CHAR NOT NULL,
    mark INT ,-- Сложность в баллах числом
    right_answer VARCHAR(255) ,
    incorrectAnswer1 VARCHAR(255),
    incorrectAnswer2 VARCHAR(255),
    incorrectAnswer3 VARCHAR(255),
    chapter INT NOT NULL
)
-- Table: couples
CREATE TABLE couples
(
    id       VARCHAR(255)      NOT NULL PRIMARY KEY,
    couple_left    VARCHAR(255) NOT NULL,
    couple_right    VARCHAR(255) NOT NULL,
    number_of_chapter INT NOT NULL,
    number_of_inset INT NOT NULL
)
