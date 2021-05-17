create table public.user_score
(
    id bigserial not null
        constraint user_and_score_pkey
            primary key,
    score varchar(255),
    user_id varchar(255)
);

alter table public.user_score owner to mick;

create unique index user_and_score_user_id_uindex
    on public.user_score (user_id);