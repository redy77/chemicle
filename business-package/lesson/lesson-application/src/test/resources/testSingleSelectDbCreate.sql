drop table if exists chemistry_single_select_task;
drop table if exists chemistry_single_select_task_event;

create table chemistry_single_select_task (
                                        id varchar(255) not null,
                                        chapter_id int4,
                                        description varchar(10000),
                                        reference_id int4,
                                        correct_answer varchar(255),
                                        incorrect_answer_one varchar(255),
                                        incorrect_answer_two varchar(255),
                                        incorrect_answer_three varchar(255),
                                        incorrect_answer_four varchar(255),
                                        primary key (id)
);

create table chemistry_single_select_task_event (
                                              id varchar(255) not null,
                                              author_id varchar(255),
                                              entity_id varchar(255),
                                              occuring_comtext varchar(255),
                                              occuring_context_time timestamp,
                                              payload jsonb,
                                              event_type int4,
                                              event_version varchar(255),
                                              primary key (id)
);

INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('1', 1, 'chemistry_fixed_answer', 4, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');
INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('2', 2, 'chemistry_fixed_answer', 4, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');
INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('3', 2, 'chemistry_fixed_answer', 4, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');
INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('4', 3, 'chemistry_fixed_answer', 4, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');
INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('5', 3, 'chemistry_fixed_answer', 3, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');
INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('6', 3, 'chemistry_fixed_answer', 3, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');
INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('7', 4, 'chemistry_fixed_answer', 3, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');
INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('8', 4, 'chemistry_fixed_answer', 2, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');
INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('9', 4, 'chemistry_fixed_answer', 2, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');
INSERT INTO chemistry_single_select_task (id, chapter_id, description, reference_id, correct_answer, incorrect_answer_one, incorrect_answer_two, incorrect_answer_three, incorrect_answer_four)
VALUES ('10', 4, 'chemistry_fixed_answer', 1, 'correct_answer', 'incorrect_answer_one', 'incorrect_answer_two', 'incorrect_answer_three', 'incorrect_answer_four');