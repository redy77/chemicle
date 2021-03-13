create table if not exists comment (
                                       id  bigserial not null,
                                       author varchar(255),
                                       comment varchar(255),
                                       date varchar(255),
                                       primary key (id));

create table if not exists lesson (
                                      id  bigserial not null,
                                      content varchar(3000),
                                      lesson_name varchar(255),
                                      primary key (id));

create table if not exists lesson_comments (
                                               lesson_id int8 not null,
                                               comment_id int8 not null);

insert into lesson (id, content, lesson_name) VALUES (1,'Content 1. Законность референдума не признают и Западные страны, которые после событий Крымской весны ввели против России ряд санкций. Дискуссии на счет присоединения полуострова не смолкают до сих пор. Однако Владимир Путин указывает, что вопрос Крыма для нашей страны "закрыт окончательно".','Диэтиломид лизергиновой кислоты. В простанароде ЛСД Производство в домашних условиях');
insert into lesson (id, content, lesson_name) VALUES (2,'Content 2. Напомним, Крым присоединился к России в ходе референдума, на котором почти 97% крымчан выразили желание войти в состав страны. Украина считает, что в 2014 году произошла "аннексия" полуострова и называет Крым украинской, но оккупированной территорией.','Органическая химия часть II');