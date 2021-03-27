DELETE FROM chemistry_fixed_answer;

INSERT INTO chemistry_fixed_answer
    (task_id, chapter_id, description, reference_id, right_answer)
VALUES (1, 1, 111, 1, 111),
       (2, 2, 222, 2, 222),
       (3, 3, 333, 3, 333),
       (4, 4, 444, 4, 444);
